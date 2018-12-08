import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
<<<<<<< HEAD
import {CategoryComponent} from "./component/category/category.component";
import {CategoriesComponent} from "./component/categories/categories.component";
import {ProductComponent} from "./component/product/product.component";
import {ProductsComponent} from "./component/products/products.component";
=======
import { RegisterComponent } from './register/register.component';
>>>>>>> 1647e9fbfbd82b9b9e7213406dc1738a8df32168

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegisterComponent}];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
<<<<<<< HEAD
    CategoryComponent,
    CategoriesComponent,
    ProductComponent,
    ProductsComponent
=======
    RegisterComponent
>>>>>>> 1647e9fbfbd82b9b9e7213406dc1738a8df32168
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
