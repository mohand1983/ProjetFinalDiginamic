import { distinctUntilChanged, take, tap } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { ApiService } from '@core/services/http/api.service';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { Utilisateur } from '@shared/models/utilisateur.model';
import { JwtService } from './jwt.service';
import { UtilisateurSecret } from '@core/models/utilisateur.secret';

/**
 * Provides a base for auth workflow
 */
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private readonly _ROOT_PATH = 'auth';

  private _utilisateur = new BehaviorSubject<UtilisateurSecret>(
    {} as UtilisateurSecret
  );
  private _authenticated = new BehaviorSubject<boolean>(false);

  constructor(
    private _api: ApiService<UtilisateurSecret>,
    private _jwtService: JwtService
  ) {
    if (this._jwtService.getToken()) {
      this._populate();
    }
  }

  get currentUtilisateur() {
    return this._utilisateur.asObservable().pipe(distinctUntilChanged());
  }

  get currentAuthenticated() {
    return this._authenticated.asObservable().pipe(tap(console.log), take(1));
  }

  /**
   * TODO check if behaves correctly on unsubscribe of consuming entity, GOD NEEDS TESTING !!!
   *
   * must be unsubscribed
   */
  attemptAuth(utilisateur: UtilisateurSecret, signup = false) {
    const onConnect = signup
      ? this._signup(utilisateur)
      : this._login(utilisateur);
    return onConnect.subscribe({
      // next: (utilisateur) => this._setAuth(utilisateur),
      next: () => this._mockSetAuth(),
      // error: () => this._purgeAuth(),
      error: () => this._mockSetAuth(),
    });
  }

  attemptPurge(signout = false) {
    const onExit = signout ? this._signout() : this._logout();
    return onExit.subscribe({ next: () => this._purgeAuth() });
  }

  private _populate() {
    return this._authMe().subscribe({
      // next: (utilisateur) => this._setAuth(utilisateur),
      next: () => this._mockSetAuth(),
      // error: () => this._purgeAuth(),
      error: () => this._mockSetAuth(),
    });
  }

  private _setAuth(utilisateur: UtilisateurSecret) {
    this._authenticated.next(true);
    this._utilisateur.next(utilisateur);
    this._jwtService.saveToken(utilisateur.token);
  }

  private _mockSetAuth() {
    console.log('mocking auth');

    this._authenticated.next(true);
    this._utilisateur.next({
      nom: 'admin',
      email: 'admin@test.com',
      token: 'token',
    } as UtilisateurSecret);
    this._jwtService.saveToken('token');
  }

  private _purgeAuth() {
    this._authenticated.next(false);
    this._utilisateur.next({} as UtilisateurSecret);
    this._jwtService.destroyToken();
  }

  private _authMe() {
    return this._api.fetch('auth', 'me');
  }

  private _login(utilisateur: UtilisateurSecret) {
    return this._api.createAt('auth', 'login', utilisateur);
  }

  private _signup(utilisateur: UtilisateurSecret) {
    return this._api.createAt('auth', 'signup', utilisateur);
  }

  private _logout() {
    return this._api.delete('auth', 'logout');
  }

  private _signout() {
    return this._api.delete('auth', 'signout');
  }
}
