import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Product} from "../model/product";
import {Category} from "../model/category";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

   public getAllProducts(): Observable<Array<Product>> {
    return this.http.get<Array<Product>>('http://localhost:8080/category/id/products');
   }
   public getProduct(id: string): Observable<Product> {
    return this.http.get<Product>('http://localhost:8080/products/'.concat(id));
   }
}
