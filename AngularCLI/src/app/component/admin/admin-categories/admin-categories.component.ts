import { Component, OnInit } from '@angular/core';
import {Category} from "../../../model/category";

@Component({
  selector: 'app-admin-categories',
  templateUrl: './admin-categories.component.html',
  styleUrls: ['./admin-categories.component.css']
})
export class AdminCategoriesComponent implements OnInit {

  categories: Array<Category> = [];

  constructor() { }

  ngOnInit() {
  }

}
