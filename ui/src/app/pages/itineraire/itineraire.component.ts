import { Itineraire } from '@app/shared/models/itineraire.model';
import { ItineraireService } from './../../shared/services/http/itineraire.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-itineraire',
  templateUrl: './itineraire.component.html',
  styleUrls: ['./itineraire.component.scss'],
})
export class ItineraireComponent implements OnInit {
  itineraire!: Itineraire;
  errorMessage!: string;

  constructor(
    private itineraireService: ItineraireService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get('id');

    if (!!id) {
      this.itineraireService.getById(id).subscribe({
        next: (itineraire) => {
          this.itineraire = itineraire;
        },
      });
    }
  }
}
