import { LoginService } from './../../services/login.service';
import { Component, OnInit, Input } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { RouterEvent, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})

export class HeaderComponent implements OnInit {
  flag: boolean;
 userLogged: boolean;
 userLoggedIn: boolean;
  products: any = [];
  constructor(private route: Router, private loginService: LoginService) { }
  @Input() name;
condition: boolean;
text: String;
  ngOnInit() {
    console.log(this.name);
    if (localStorage.getItem('token') !== null ) {
      this.flag = true;
      this.userLoggedIn = true;
     this.userLogged = false;
    } else {
      this.flag = false;
     this.userLogged = true;
     this.userLoggedIn = false;
       }
   }

  Login() {
    this.route.navigate(['/' , 'login']);
  }
  Logout() {
    this.loginService.logout();
     this.flag = false;
     this.userLogged = true;
   // location.reload();
  }
  // Cartbutton() {
  //   this.loginService.logout();
  //   this.flag = false;
  //   this.userLogged = true;
  // }
  Signup() {
    this.route.navigate(['/' , 'Signup']);
  }
  Cartbutton() {
    this.route.navigate(['/', 'cartbutton']);
  }
  profile() {
    this.route.navigate(['/', 'profile']);
  }
  searchbar() {
    this.route.navigate(['/', 'search', this.text]);
  }
  logout() {
    this.loginService.logout();
     this.flag = false;
     this.userLogged = true;
  }
  search(value) {
    this.text = value;
  }
}
