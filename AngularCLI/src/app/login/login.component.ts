import { Component, OnInit } from '@angular/core';
import {User} from "../model/user";
import {UserService} from "../service/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User;
  massage: String = '';

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  public login() {
    this.userService.login(this.user).subscribe(
      resp => {
        this.router.navigate(['/categories']);
      },
      err => {
        this.massage = 'Incorrect email or password';
      }
    );
  }
}
