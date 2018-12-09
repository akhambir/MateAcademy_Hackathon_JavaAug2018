import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
<<<<<<< HEAD
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
=======
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
>>>>>>> 17fced9b0c218974462f93b07c9d56a501087950

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {NgbPaginationModule, NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';


import {CategoryComponent} from "./component/category/category.component";
import {CategoriesComponent} from "./component/categories/categories.component";
import {ProductComponent} from "./component/product/product.component";

import { RegisterComponent } from './register/register.component';
import { PersonalAreaComponent } from './personal-area/personal-area.component';
import { HomeComponent } from './home/home.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CartComponent } from './component/cart/cart.component';
import { AdminCategoriesComponent } from './component/admin/admin-categories/admin-categories.component';
import { AdminCategoryComponent } from './component/admin/admin-category/admin-category.component';


const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegisterComponent},
  {path: 'personalArea', component: PersonalAreaComponent},
  {path: 'categories', component: CategoriesComponent},
  {path: 'category', component: CategoryComponent},
  {path: 'personalArea', component: PersonalAreaComponent},
  {path: '', component: HomeComponent}
  {path: 'product', component: ProductComponent},
  {path: 'personalArea', component: PersonalAreaComponent},
  {path: 'cart', component: CartComponent},
  {path: 'admin/categories', component: AdminCategoriesComponent},
  {path: 'admin/category', component: AdminCategoryComponent},
  {path: 'admin/categories', component: AdminCategoriesComponent}
  ];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    PersonalAreaComponent,
    CategoryComponent,
    CategoriesComponent,
    ProductComponent,
    RegisterComponent,
<<<<<<< HEAD
    HomeComponent
=======
    CartComponent,
    AdminCategoriesComponent,
    AdminCategoryComponent,
>>>>>>> 17fced9b0c218974462f93b07c9d56a501087950
  ],
  imports: [
    RouterModule.forRoot(appRoutes,
      {enableTracing: true}),
    HttpClientModule,
    BrowserModule,
    FormsModule,
<<<<<<< HEAD
    NgbModule,
    NgbPaginationModule,
    NgbAlertModule
=======
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule
>>>>>>> 17fced9b0c218974462f93b07c9d56a501087950
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
