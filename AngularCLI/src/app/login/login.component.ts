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

  user: User = new User();

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  public login() {
    console.log(this.user);
    this.userService.login(this.user).subscribe(
      resp => {
        this.router.navigate(['/categories']);
      },
      err => {
        console.log(err);
      }
    );
  }
}
