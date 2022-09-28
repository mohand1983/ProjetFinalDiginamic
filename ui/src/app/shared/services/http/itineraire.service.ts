import { ApiService } from '../../../core/services/http/api.service';
import { Injectable, OnInit } from '@angular/core';
import { Itineraire } from '@app/shared/models/itineraire.model';
import { HttpParams } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { FormGroup, FormBuilder } from '@angular/forms';
import { switchMap, take, tap } from 'rxjs';
import { Filter } from '@shared/interfaces/filter';

@Injectable({
  providedIn: 'root',
})
export class ItineraireService {
  private readonly _ROOT_PATH = 'itineraire';

  private readonly _DEFAULT_FILTER = {
    region: ['Cevennes'],
    nomItineraire: [''],
    pratique: [''],
    typeItineraire: [''],
    difficulte: [''],
    dureeMin: ['1'],
    dureeMax: ['120'],
    longueurMin: ['1'],
    longueurMax: ['200000'],
  };

  /**
   * unsed -> to retrofit
   *
   * trying to build a preconfigured filter matching page object
   * objective is to only use filter.value to minimize code noise
   */
  private readonly _ALT_FILTER = {
    subject: this._fb.group({
      region: ['Cevennes'],
      nomItineraire: [''],
      pratique: [''],
      typeItineraire: [''],
      difficulte: [''],
    }),
    filters: this._fb.group({
      dureeMin: ['1'],
      dureeMax: ['120'],
      longueurMin: ['1'],
      longueurMax: ['200000'],
    }),
  };

  /**
   * cette attribut va represente l'état du filtre sur les itineraires affichés
   */
  private _filter = new BehaviorSubject<FormGroup>(
    this._fb.group(this._DEFAULT_FILTER)
  );

  constructor(private _api: ApiService<Itineraire>, private _fb: FormBuilder) {}

  /**
   * en s'abonnant à cette propriété il est possible d'effectuer une action a chaque changement de l'état du filtre sur les itineraires
   */
  get filter() {
    return this._filter;
  }

  /**
   * en s'abonnant a cette propriété il est possible de recuperer l'etat actuel du filtre sur les itineraires
   * apres execution de la commande next la souscription est supprimée grace au take(1)
   */
  get currentFilter() {
    return this._filter.asObservable().pipe(take(1));
  }

  getPage(page: HttpParams) {
    return this._api.fetchPageAt('itineraire', 'sliced', page);
  }

  getFilteredPage(params: HttpParams) {
    return this.filter.pipe(
      switchMap((filter) =>
        this._api.fetchFilteredPageAt(
          'itineraire',
          'filtered',
          this._getItineraireExempleFromFilter(filter),
          params
        )
      )
    );
  }

  getById(id: string) {
    return this._api.fetch('itineraire', id);
  }

  getMatchingFilter(filtre: any) {
    return this._api.fetchMatchingAt('itineraire', 'filtre', filtre);
  }

  resetFilter() {
    this._filter.next(this._fb.group(this._DEFAULT_FILTER));
  }

  addFilter(filter: FormGroup) {
    this._filter.next(filter);
  }

  private _getItineraireExempleFromFilter(filter: FormGroup) {
    return {
      subject: filter.value as Itineraire,
    } as Filter<Itineraire>;
  }
}
