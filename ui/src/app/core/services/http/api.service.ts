import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Filter } from '@shared/interfaces/filter';
import { retry } from 'rxjs/internal/operators/retry';
import { take } from 'rxjs/internal/operators/take';
import { Page } from '../../../shared/interfaces/page';

/**
 * cette classe permet de definir de facon
 * generique le fonctionnement d'un connecteur a une api
 *
 * pipe(take(1)) sur chaque requete permet de fermer la souscription à la reponse
 */
@Injectable({
  providedIn: 'root',
})
export class ApiService<T> {
  urlApi = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  fetchPage(route: string, params: HttpParams) {
    return this.http
      .get<Page<T>>(`${this.urlApi}/${route}`, {
        params,
      })
      .pipe(take(1));
  }

  fetchPageAt(route: string, path: string, params: HttpParams) {
    return this.http
      .get<Page<T>>(`${this.urlApi}/${route}/${path}`, {
        params,
      })
      .pipe(take(1));
  }

  fetchFilteredPage(route: string, body: Filter<T>, params: HttpParams) {
    return this.http
      .post<Page<T>>(`${this.urlApi}/${route}`, body, {
        params,
      })
      .pipe(retry(1), take(1));
  }

  fetchFilteredPageAt(
    route: string,
    path: string,
    body: Filter<T>,
    params: HttpParams
  ) {
    return this.http
      .post<Page<T>>(`${this.urlApi}/${route}/${path}`, body, {
        params,
      })
      .pipe(retry(1), take(1));
  }

  fetch(route: string, target: string) {
    return this.http.get<T>(`${this.urlApi}/${route}/${target}`).pipe(take(1));
  }

  fetchAt(route: string, path: string, target: string) {
    return this.http
      .get<T>(`${this.urlApi}/${route}/${path}/${target}`)
      .pipe(take(1));
  }

  fetchMatching(route: string, body: any) {
    return this.http.post<T[]>(`${this.urlApi}/${route}`, body).pipe(take(1));
  }

  fetchMatchingAt(route: string, path: string, body: any) {
    return this.http
      .post<T[]>(`${this.urlApi}/${route}/${path}`, body)
      .pipe(take(1));
  }

  fetchAll(route: string) {
    return this.http.get<T[]>(`${this.urlApi}/${route}`).pipe(take(1));
  }

  create(route: string, body: T) {
    return this.http.post<T>(`${this.urlApi}/${route}`, body).pipe(take(1));
  }

  createAt(route: string, path: string, body: T) {
    return this.http
      .post<T>(`${this.urlApi}/${route}/${path}`, body)
      .pipe(take(1));
  }

  delete(route: string, target: string) {
    return this.http
      .delete<boolean>(`${this.urlApi}/${route}/${target}`)
      .pipe(take(1));
  }

  deleteAt(route: string, path: string, target: string) {
    return this.http
      .delete<boolean>(`${this.urlApi}/${route}/${path}/${target}`)
      .pipe(take(1));
  }

  update(route: string, body: T) {
    return this.http.put<T>(`${this.urlApi}/${route}`, body).pipe(take(1));
  }

  updateAt(route: string, path: string, body: T) {
    return this.http
      .put<T>(`${this.urlApi}/${route}/${path}`, body)
      .pipe(take(1));
  }
}
