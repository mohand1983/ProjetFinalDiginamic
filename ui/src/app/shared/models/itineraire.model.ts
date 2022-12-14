export interface Itineraire {
  id?: number;
  idLocal?: number;
  producteur?: string;
  contact?: string;
  uuid?: string;
  url?: string;
  idOsm?: string;
  nomItineraire?: string;
  pratique?: string;
  typeItineraire?: string;
  communesNom?: string;
  communesCode?: string;
  depart?: string;
  arrivee?: string;
  duree?: number;
  balisage?: string;
  longueur?: number;
  difficulte?: string;
  altitudeMax?: number;
  altitudeMin?: number;
  denivelePositif?: number;
  deniveleNegatif?: number;
  instructions?: string;
  presentation?: string;
  presentationCourte?: string;
  themes?: string;
  recommandations?: string;
  accessibilite?: string;
  accesRoutier?: string;
  transportsCommun?: string;
  parkingInfo?: string;
  parkingGeometrie?: string;
  dateCreation?: Date;
  dateModification?: Date;
  itineraireParent?: string;
  typeSol?: string;
  pdiprInscription?: string;
  pdiprDateInscription?: string;
  arrive?: string;
  recommendations?: string;
}
