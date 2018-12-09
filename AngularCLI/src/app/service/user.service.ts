import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {User} from "../model/user";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}

  public addUser(user: User): Observable<User> {
    return this.http.post<User>(
      'http://localhost:8080/users', user
    );
  }

  public login(user: User): Observable<boolean> {
    let form: FormData = new FormData();
    form.append('username', user.email);
    form.append('password', user.password);
    return this.http.post<User>(
      'http://localhost:8080/login', form, {responseType: 'text'}).pipe(
        map(resp => {
          console.log(resp);
          localStorage.setItem('email', JSON.stringify(user));
          return true;
        }));
  }

  public pollUser(): Observable<User> {
    let user: User = new User();
    user.email = JSON.parse(localStorage.getItem('email')).user;

    return this.http.post<User>('http://localhost:8080/user/by-email', user);
  }
}
