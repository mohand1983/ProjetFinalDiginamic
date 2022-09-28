import {
  HttpEvent,
  HttpHandler,
  HttpHeaders,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtService } from '@core/services/auth/jwt.service';

/**
 * Adds header authorization to the request using in storage token
 */
@Injectable()
export class HttpTokenInterceptor implements HttpInterceptor {
  constructor(private jwtService: JwtService) {}

  /**
   * intercete toutes les requetes http de effectues par l'application
   * et rajoute le token si present localement
   *
   * @param req la requete http effectue avant interception
   * @param next la requete potentiellement modifie apres interception
   * @returns la requete potentiolement modifie a envoyer
   */
  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const token = this.jwtService.getToken();

    /**
     * recree les entetes de la requete http avec le token stocke localement
     */
    return next.handle(
      req.clone({
        headers:
          token !== null
            ? req.headers.append('Authorization', `Bearer ${token}`)
            : req.headers,
      })
    );
  }
}
