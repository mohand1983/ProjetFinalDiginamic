import { HttpParams } from '@angular/common/http';
import { Itineraire } from '@shared/models/itineraire.model';
import { ItineraireService } from '@shared/services/http/itineraire.service';
import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { switchMap } from 'rxjs/internal/operators/switchMap';
import { tap } from 'rxjs/internal/operators/tap';

@Component({
  selector: 'app-filtre-itineraire',
  templateUrl: './filtre-itineraire.component.html',
  styleUrls: ['./filtre-itineraire.component.scss'],
})
export class FiltreItineraireComponent {
  filter!: FormGroup;

  constructor(private _itineraireService: ItineraireService) {
    this._getFilter();
  }

  updateForm() {
    this._itineraireService.addFilter(this.filter);
  }

  resetFilter() {
    this._itineraireService.resetFilter();
  }

  private _getFilter() {
    this._itineraireService.filter.subscribe({
      next: (filter) => (this.filter = filter),
    });
  }
}
