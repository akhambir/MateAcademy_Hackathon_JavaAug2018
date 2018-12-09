import { Component, OnInit } from '@angular/core';
import {Category} from "../../../model/category";
import {Product} from "../../../model/product";

@Component({
  selector: 'app-admin-category',
  templateUrl: './admin-category.component.html',
  styleUrls: ['./admin-category.component.css']
})
export class AdminCategoryComponent implements OnInit {

  products: Array<Product> = [];
  category: Category = new Category();

  constructor() { }

  ngOnInit() {
  }

}
