import { UtilisateurSecret } from './../../../core/models/utilisateur.secret';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from '@core/services/auth/auth.service';

@Component({
  selector: 'app-form-sign-up',
  templateUrl: './form-sign-up.component.html',
  styleUrls: ['./form-sign-up.component.scss'],
})
export class FormLoginComponent {
  private readonly _DEFAULT_FORM = {
    prenom: [''],
    nom: [''],
    telephone: [''],
    email: [''],
    password: [''],
  };

  signUp = this._fb.group(this._DEFAULT_FORM);

  constructor(private _authservice: AuthService, private _fb: FormBuilder) {}

  attemptAuth(signingUp: boolean): void {
    this._authservice.attemptAuth(
      this.signUp.value as UtilisateurSecret,
      signingUp
    );
  }

  resetForm() {
    this.signUp = this._fb.group(this._DEFAULT_FORM);
  }
}
