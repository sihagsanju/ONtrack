import { BuyingHistoryComponent } from './../buying-history/buying-history.component';
import { Ontrack } from './../../classes/ontrack';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { OnTrackService } from '../../services/ontrack.service';
import { Button } from 'protractor';
import { DefaultFlexOrderDirective } from '@angular/flex-layout';
import { Order } from './../../classes/Order';
import { DatePipe} from '@angular/common';

@Component({
selector: 'app-buy',
templateUrl: './buy.component.html',
styleUrls: ['./buy.component.scss']
})
export class BuyComponent implements OnInit {
price: number;
charge: any;
p: any;
r: any;
order: Order;
slots: any;
slotType: String;
date: any;
slotsSelected: any;
slotsAvailable: any = [];
totalPrice() {
console.log('this is child');
}
constructor(private route: Router, private onTrack: OnTrackService, private datepipe: DatePipe) {  }
 ngOnInit() {
    this.order = new Order();
    this.order.orderDate = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    this.order.orderId = Number(Math.floor((Math.random() * 6) + 1));
    this.order.productCount = Number(sessionStorage.getItem('price'));
    this.onTrack.Buy(this.order).subscribe(data => {
    console.log('data fetch from response', data);
    this.slots = data;
    this.slotsAvailable = this.slots.slotAvailabilities;
    console.log('response from data is slotavaaialbel', this.slotsAvailable);
    this.price = Number(sessionStorage.getItem('price'));
 });
}
slot(value) {
   this.date = value.date;
   console.log('date value is ', this.date);
   localStorage.setItem('date', this.date);
   this.slotsSelected = value;
   console.log('this is the value of slots', this.slotsSelected);
   this.slotsSelected.slots.map( resp => {
      this.charge = resp.cost;
      this.slotType = resp.slotType;
   });
  //  this.charge = this.slotsSelected.cost;
  // this.slotType = this.slotsSelected.slotType;
  console.log('slottype value is', this.slotType);
  localStorage.setItem('slot', this.slotType.toString());
  console.log('this is the charge value', this.charge);
      sessionStorage.setItem('charge', this.charge);
}
shop() {
this.route.navigate(['/' , 'payment']);
}
}
