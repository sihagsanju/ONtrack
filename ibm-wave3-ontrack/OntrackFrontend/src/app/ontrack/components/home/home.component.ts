import { Component, OnInit } from '@angular/core';
import { Profile } from 'selenium-webdriver/firefox';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  route: any;

  constructor() { }
  Profile() {
    this.route.navigate(['/' , 'profile']);
  }
  ngOnInit() {
  }
}
