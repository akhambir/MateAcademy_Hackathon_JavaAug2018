import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  private products: Array<Product> = [];

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.productService.getAllProducts()
      .subscribe(
        resp => {
          this.products = resp;
        }
      );
  }

}
