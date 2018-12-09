import { Component, OnInit } from '@angular/core';
import {Category} from '../../model/category';
import {CategoriesService} from "../../service/categories.service";

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories: Array<Category> = [];

  constructor(private categoriesService: CategoriesService) {
  }

  ngOnInit() {
    this.categoriesService.getAllCategories()
      .subscribe(
        resp => {
          this.categories = resp;
        }
      );
  }

}
