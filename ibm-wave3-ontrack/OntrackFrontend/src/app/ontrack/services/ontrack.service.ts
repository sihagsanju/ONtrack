// import { BuyComponent } from '../components/buy/buy.component';

import { HttpClient , HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { Slot } from '../classes/Slot';
import { Order } from '../classes/Order';
import { SelectedSlot } from '../classes/SelectedSlot';


@Injectable()
export class OnTrackService {
    url: any;
    response: any;
     cart;
     httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
      };
    constructor(private http: HttpClient) {

    }
   Home() {

    this.url = 'http://localhost:8083/api/v1/products';
    console.log('this method call');
    return this.http.get(this.url);
}

openDailog() {
    this.url = 'http://localhost:8083/api/v1/products';
    return this.http.get(this.url);
}
AddToCart() {
    this.url = 'http://localhost:8083/api/v1/products';
    return this.http.get(this.url);
}
Buy(order: Order) {

    this.url = ' http://ontrack-zuul.stackroute.io:8092/delivery-manager/api/v1/slot';
    return this.http.post(this.url, JSON.stringify(order) , this.httpOptions);
 }
 OrderSave(slot: Slot) {
   this.url = 'http://ontrack-zuul.stackroute.io:8092/delivery-manager/api/v1/saveorder';
    return this.http.post(this.url, JSON.stringify(slot), this.httpOptions);
 }
profile() {
    this.url = 'http://localhost:8015/user-registration/api/v1/user/';
    return this.http.get(this.url);
}
REMOVE() {
    this.url = 'http://localhost:8083/api/v1/AddToCart';
    return this.http.get(this.url);
 }

 saveSlot(selectedSlot: SelectedSlot) {
     this.url = 'http://13.234.142.187:8015/delivery-manager/v1/slotbooked';
      return this.http.post(this.url, JSON.stringify(selectedSlot), this.httpOptions);
 }
}
