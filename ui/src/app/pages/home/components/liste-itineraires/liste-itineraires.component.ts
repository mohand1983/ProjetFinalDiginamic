import { Itineraire } from '@app/shared/models/itineraire.model';
import { ItineraireService } from '@shared/services/http/itineraire.service';
import { Component, Input, OnInit } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { Page } from '@app/shared/interfaces/page';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { take } from 'rxjs/internal/operators/take';
import { switchMap } from 'rxjs/internal/operators/switchMap';
import { FormGroup } from '@angular/forms';
import { tap } from 'rxjs/internal/operators/tap';

@Component({
  selector: 'app-liste-itineraires',
  templateUrl: './liste-itineraires.component.html',
  styleUrls: ['./liste-itineraires.component.scss'],
})
export class ListeItinerairesComponent implements OnInit {
  @Input() recover = false;

  page!: Page<Itineraire>;
  itineraires!: Itineraire[];
  errorMessage!: string;

  private _pageNumber = new BehaviorSubject<number>(0);

  constructor(private itineraireService: ItineraireService) {
    this._onPageChange();
    this._onFilterChange();
  }

  ngOnInit(): void {
    this._pageNumber.next(0);
  }

  onPrevious(e: Event) {
    e.preventDefault();
    if (!!!this.page.first) {
      this.currentPage.subscribe((number) => this._pageNumber.next(--number));
    }
  }

  onNext(e: Event) {
    e.preventDefault();
    if (!!!this.page.last) {
      this.currentPage.subscribe((number) => this._pageNumber.next(++number));
    }
  }

  get currentPage() {
    return this._pageNumber.asObservable().pipe(take(1));
  }

  private _onPageChange() {
    this._pageNumber
      .pipe(
        switchMap((number) =>
          this.itineraireService.getFilteredPage(
            new HttpParams({
              fromObject: {
                page: number,
              },
            })
          )
        )
      )
      .subscribe({
        next: (page) => {
          this.page = page;
          this.itineraires = page?.content;
        },
        error: (message) => (this.errorMessage = message),
      });
  }

  private _onFilterChange() {
    this.itineraireService.filter
      .pipe(switchMap(() => this.currentPage))
      .subscribe(() => this._pageNumber.next(0));
  }
}
