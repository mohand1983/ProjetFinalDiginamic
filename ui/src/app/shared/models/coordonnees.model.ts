import { Itineraire } from './itineraire.model';

export interface Coordonnees {
  id?: number;
  longitude?: number;
  latitude?: number;
  itineraire?: Itineraire;
}
