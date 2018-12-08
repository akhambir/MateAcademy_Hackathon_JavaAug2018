import { Component, OnInit } from '@angular/core';
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  private category: Category = new Category();

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit() {

  }

  public getCategory(id: string) {
    this.categoryService.getCategory(id)
      .subscribe(
        resp => {
          this.category = resp;
        }
      );
  }
}
