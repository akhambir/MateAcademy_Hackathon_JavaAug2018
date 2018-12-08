import { Component, OnInit } from '@angular/core';
import {User} from "../model/user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User;
  massage: String = '';

  constructor() { }

  ngOnInit() {
  }

  /*public login(user: User) {
  .subscribe(
      resp => {

      },
      err => {
        this.massage = 'Incorrect email or password';
      }
    );
  }*/
}
