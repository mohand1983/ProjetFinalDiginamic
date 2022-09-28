import { AuthGuard } from './core/guards/auth.guard';
import { CarouselComponent } from './pages/home/components/carousel/carousel.component';
import { ItineraireComponent } from './pages/itineraire/itineraire.component';
import { HomeComponent } from './pages/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home',
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'itineraire',
    children: [
      {
        path: ':id',
        component: ItineraireComponent,
      },
    ],
  },
  {
    path: 'evenement',
    canActivate: [AuthGuard],
    component: CarouselComponent,
  },
  {
    path: '**',
    redirectTo: '',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
