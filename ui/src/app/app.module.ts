import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarouselComponent } from './pages/home/components/carousel/carousel.component';
import { EvenementsEnCoursComponent } from './pages/home/components/evenements-en-cours/evenements-en-cours.component';
import { FiltreItineraireComponent } from './pages/home/components/filtre-itineraire/filtre-itineraire.component';
import { HeaderComponent } from './pages/home/components/header/header.component';
import { ListeItinerairesComponent } from './pages/home/components/liste-itineraires/liste-itineraires.component';
import { SearchbarComponent } from './pages/home/components/searchbar/searchbar.component';
import { HomeComponent } from './pages/home/home.component';
import { MapComponent } from './pages/itineraire/components/map/map.component';
import { ItineraireComponent } from './pages/itineraire/itineraire.component';
import { AccountComponent } from './shared/components/account/account.component';
import { FooterComponent } from './shared/components/footer/footer.component';
import { FormInscriptionComponent } from './shared/components/form-inscription/form-inscription.component';
import { FormLoginComponent } from './shared/components/form-sign-up/form-sign-up.component';
import { LogoComponent } from './shared/components/logo/logo.component';

import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpTokenInterceptor } from '@core/interceptors/http.token.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    HomeComponent,
    SearchbarComponent,
    ListeItinerairesComponent,
    EvenementsEnCoursComponent,
    HeaderComponent,
    FooterComponent,
    CarouselComponent,
    FiltreItineraireComponent,
    LogoComponent,
    AccountComponent,
    FormLoginComponent,
    ItineraireComponent,
    FormInscriptionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpTokenInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
