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
      'http://localhost:8080/registration', user
    );
  }

  /*public login(user: User): Observable<boolean> {
    return this.http.post<User>(
      'http://localhost:8080/login', user, {observe: 'response'}).pipe(
        map(resp => {
          localStorage.setItem('email', {user: user.email});
        })
    )
  }*/
  public pollUser(): Observable<User> {
    let user: User = new User();
    user.email = JSON.parse(localStorage.getItem('email')).user;

    return this.http.post<User>('http://localhost:8080/user/by-email', user);
  }
}
