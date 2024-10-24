import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from '../dto/Restaurant';
import { Page } from '../dto/Page';
import { MenuItem } from '../dto/MenuItem';
import { environment } from '../../environments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  private restaurantUrl = `${environment.baseUrl}/restaurants`;
  private menuUrl = `${environment.baseUrl}/menu-items`;

  constructor(private http: HttpClient) { }

  getAllRestaurants(page: number, size: number): Observable<Page<Restaurant>> {
    return this.http.get<Page<Restaurant>>(`${this.restaurantUrl}?page=${page}&size=${size}`);
  }

  getMenuItemsByRestaurantId(restaurantId: number): Observable<MenuItem[]> {
    return this.http.get<MenuItem[]>(`${this.menuUrl}/restaurant/${restaurantId}`);
  }
}
