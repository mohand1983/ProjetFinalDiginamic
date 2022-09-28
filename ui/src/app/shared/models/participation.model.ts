import { Utilisateur } from './utilisateur.model';
import { Evenement } from './evenement.model';
export interface Participation {
  id?: number;
  isOrganisateur?: boolean;
  dateInscription?: string;
  evenement?: Evenement;
  utilisateur?: Utilisateur;
}
