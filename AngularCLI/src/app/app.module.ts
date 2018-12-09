import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

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



const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegisterComponent},
  {path: 'categories', component: CategoriesComponent},
  {path: 'product', component: ProductComponent},
  {path: 'category', component: CategoryComponent},
  {path: 'personalArea', component: PersonalAreaComponent},
  {path: '', component: HomeComponent}
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
    HomeComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes,
      {enableTracing: true}),
    HttpClientModule,
    BrowserModule,
    FormsModule,
    NgbModule,
    NgbPaginationModule,
    NgbAlertModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
