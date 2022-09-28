import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ItineraireService } from '@shared/services/http/itineraire.service';
import { tap } from 'rxjs/internal/operators/tap';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.scss'],
})
export class SearchbarComponent {
  @Output() focus = new EventEmitter<boolean>();

  filter!: FormGroup;

  constructor(private _itineraireService: ItineraireService) {
    this._getFilter();
  }

  onFocus(e: Event) {
    e.preventDefault();
    this.focus.emit(true);
  }

  onBlur(e: Event) {
    e.preventDefault();
    this.focus.emit(false);
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
