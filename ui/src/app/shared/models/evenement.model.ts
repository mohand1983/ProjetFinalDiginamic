import { Itineraire } from './itineraire.model';
export interface Evenement {
  id?: number;
  nom?: string;
  dateCreation?: string;
  dateEvenement?: string;
  dateModification?: string;
  heureDebut?: string;
  heureFin?: string;
  itineraire?: Itineraire;
}
