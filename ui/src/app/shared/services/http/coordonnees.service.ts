import { ApiService } from '../../../core/services/http/api.service';
import { Injectable } from '@angular/core';
import { Coordonnees } from '@app/shared/models/coordonnees.model';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root',
})
export class CoordonneesService {
  constructor(private api: ApiService<Coordonnees>) {}

  fetchMatching(idItineraire: number): Observable<Coordonnees> {
    return this.api.fetch('coordonnees', `${idItineraire}`);
  }
}
