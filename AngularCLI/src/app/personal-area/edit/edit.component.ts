import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {User} from "../../model/user";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  user: User = new User();

  constructor(private userService:  UserService, private router: Router) { }

  ngOnInit() {
  }

  public updateUserInfo() {
    this.userService.updateUser(this.user).subscribe(
      resp => {
        this.router.navigate(['/personalArea']);
      }, err => {
        console.log(err);
      });
  }
}
