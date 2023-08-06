import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  constructor(private userService: UserService,
    private router: Router
    ) { }

  ngOnInit(): void {
  }




  register(registerForm: NgForm) {

    console.log(registerForm.value);
    this.userService.register(registerForm.value).subscribe(

      (resp) => {
        this.router.navigate(['/login']);
        console.log(resp)
      },

      (error) => {
        console.log(error)
      }


    );

  }
}
