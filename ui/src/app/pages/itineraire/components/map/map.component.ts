import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Coordonnees } from '@app/shared/models/coordonnees.model';
import * as L from 'leaflet';

import { environment } from './../../../../../environments/environment';
import { CoordonneesService } from './../../../../shared/services/http/coordonnees.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss'],
})
export class MapComponent implements OnInit {
  coordonnees!: Coordonnees;
  coordonnee!: number;
  errorMessage!: string;
  map: any;

  constructor(
    private coordonneesService: CoordonneesService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get('id');

    if (!!id) {
      this.coordonneesService.fetchMatching(parseInt(id)).subscribe({
        next: (coordonnees) => {
          /*this.coordonnees = coordonnees;
          for( let coordonnee of this.coordonnees) {
            console.log(this.coordonnee);
          }

          this.coordonnees.latitude = coordonnees.latitude;
          this.coordonnees.longitude = coordonnees.longitude;
          console.log(coordonnees.latitude,coordonnees.longitude);*/
          this.loadMap(44.184696270,3.608586955);
        },

      });

    }
  }

  /*public ngAfterViewInit(): void {
    this.loadMap();
  }*/

  private loadMap(latitude: number, longitude: number): void {
    this.map = L.map('map').setView([latitude, longitude], 10);
    L.tileLayer(
      'https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}',
      {
        attribution:
          'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1,
        accessToken: environment.mapbox.accessToken,
      }

    ).addTo(this.map);
    const icon = L.icon({
      iconUrl: '../../../../../assets/img/marker-icon.png',
      shadowUrl: '../../../../../assets/img/marker-shadow.png',
      popupAnchor: [13, 0],
    });
    const marker = L.marker([latitude, longitude], { icon }).bindPopup(
      'Angular Leaflet'
    );
    marker.addTo(this.map);
  }
}
