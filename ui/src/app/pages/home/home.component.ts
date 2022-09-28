import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent {
  isSearching = false;
  isFiltering = false;
  isBrowsing = false;
  wasFiltering = false;
  wasBrowsing = false;
  isCheckingProfile = false;

  toggleProfileOptions(e: Event) {
    e.preventDefault();
    this.isCheckingProfile = !this.isCheckingProfile;
  }

  toggleSearch(focus: boolean) {
    this.isSearching = focus;
  }

  filter(filtering: boolean) {
    this.isFiltering = filtering;
    this.wasFiltering = !filtering;
  }

  browse(browsing: boolean) {
    this.isBrowsing = browsing;
    this.wasBrowsing = !browsing;
  }

  resetView() {
    if (!this.isBrowsing) {
      this.hideFilter();
      this.hideList();
      this.isCheckingProfile = false;
    }
  }

  hideFilter() {
    this.isFiltering = false;
    this.wasFiltering = false;
  }

  hideList() {
    this.isBrowsing = false;
    this.wasBrowsing = false;
  }
}
