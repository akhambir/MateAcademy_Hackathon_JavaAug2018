import { Component, OnInit } from '@angular/core';
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";
import {Product} from "../../model/product";
import {ProductComponent} from "../product/product.component";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  products: Array<Product> = [];
  category: Category = new Category();

  constructor(private categoryService: CategoryService, private productService: ProductService) {
  }

  ngOnInit() {
    this.productService.getAllProducts()
      .subscribe(
        resp => {
          this.products = resp;
        }
      );
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
