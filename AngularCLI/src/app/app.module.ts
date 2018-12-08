import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {LoginComponent} from './login/login.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

import {CategoryComponent} from "./component/category/category.component";
import {CategoriesComponent} from "./component/categories/categories.component";
import {ProductComponent} from "./component/product/product.component";

import {RegisterComponent} from './register/register.component';
import {PersonalAreaComponent} from './personal-area/personal-area.component';


const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegisterComponent},
  {path: 'categories', component: CategoriesComponent},
  {path: 'product', component: ProductComponent},
  {path: 'category', component: CategoryComponent},
  {path: 'personalArea', component: PersonalAreaComponent}
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
    RegisterComponent
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
export class AppModule {
}
