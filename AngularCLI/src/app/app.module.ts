import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {CategoryComponent} from "./component/category/category.component";
import {CategoriesComponent} from "./component/categories/categories.component";
import {ProductComponent} from "./component/product/product.component";
import {ProductsComponent} from "./component/products/products.component";

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent}
  ]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    CategoryComponent,
    CategoriesComponent,
    ProductComponent,
    ProductsComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes,
      {enableTracing: true}),
    HttpClientModule,
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
