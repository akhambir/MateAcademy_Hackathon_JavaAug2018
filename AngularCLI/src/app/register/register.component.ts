import { Component, OnInit } from '@angular/core';
import {UserService} from "../service/user.service";
import {User} from "../model/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  public registerUser() {
    this.userService.addUser(this.user).subscribe(
      resp => {
        this.router.navigate(['/login']);
      }, err => {
        console.log(err);
    }
    )
  }
}
