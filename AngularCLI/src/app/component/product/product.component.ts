import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product: Product = new Product();

  constructor(private productService: ProductService) { }

  ngOnInit() {
  }

  public getProduct(id: string) {
    this.productService.getProduct(id)
      .subscribe(
        resp => {
          this.product = resp;
        }
      );
  }
}
