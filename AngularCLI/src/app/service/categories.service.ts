import { Injectable } from '@angular/core';
import {Category} from "../model/category";
import {Observable} from "rxjs/internal/Observable";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  constructor(private http: HttpClient) { }

  public getAllCategories(): Observable<Array<Category>> {
    return this.http.get<Array<Category>>('http://localhost:8080/categories');
  }


}
