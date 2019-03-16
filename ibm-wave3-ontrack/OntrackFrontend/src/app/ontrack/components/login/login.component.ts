import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormControl, FormGroupDirective, NgForm } from '@angular/forms'; // used for reactive forms

import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { ErrorStateMatcher } from '@angular/material';
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
  }


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {


  matcher = new MyErrorStateMatcher();
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  names;
    user = this.fb.group({ // for reactive groups, we are creating form builder groups which is where we create
      // one group and add multiple properties
    userId: ['', Validators.required],
    password: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private loginService: LoginService, private router: Router) { } // using router
  // to reroute valid logged in user to some other page
  ngOnInit() {
     this.names = true;
     console.log(this.names);
  }
  signup() {
    this.router.navigateByUrl('signup');
  }
  login() {
    this.loginService.login(this.user.value)
    .subscribe(res => {
      console.log('Res: ', res);
      if (res.message === 'User successfully logged in') {
        localStorage.setItem('token' , res.token);
        this.router.navigate([`/home`]);
      } else {
        window.alert('Credentials you entered are incorrect');
      }
    });
  }
}
