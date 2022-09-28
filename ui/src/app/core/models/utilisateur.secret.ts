import { Utilisateur } from '@shared/models/utilisateur.model';

export interface UtilisateurSecret extends Utilisateur {
  password: string;
  token: string;
}
