import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { UserAuthService } from '../services/user-auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private userService: UserService,
    private userAuthService: UserAuthService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  login(loginForm: NgForm) {
    this.userService.login(loginForm.value).subscribe(
      (response: any) => {
        this.userAuthService.setRoles1(response.user.role);

        this.userAuthService.setToken(response.jwtToken);

        const role = response.user.role;
        if (role == 'Admin') {
          console.log(role);
          this.router.navigate(['/admin']);
        } else {
          console.log(role);
          this.router.navigate(['/user']);
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }

  registerUser(){

    this.router.navigate(['/signUp'])
  }

}
