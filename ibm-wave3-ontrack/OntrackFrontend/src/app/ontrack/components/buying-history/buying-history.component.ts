import { JwtHelperService } from '@auth0/angular-jwt';

import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { AngularFireDatabase, AngularFireObject} from 'angularfire2/database';
import { Router } from '@angular/router';
import { map  } from 'rxjs/operators';

@Component({
selector: 'app-buying-history',
templateUrl: './buying-history.component.html',
styleUrls: ['./buying-history.component.scss']
})
export class BuyingHistoryComponent implements OnInit {
products: any;
dataProducts: any;

constructor(private db: AngularFireDatabase, private route: Router) {  }
private helper = new JwtHelperService();
private currentUser;
ngOnInit() {
  let itemRef = this.db.list('/products');
   let items = itemRef.snapshotChanges().pipe(map(changes => changes.map(c => ({key: c.payload.key, ...c.payload.val()}))));

   items.subscribe(data => {
    this.dataProducts = data;
    this.products = data;
    console.log('@@@@@@@^^^@@@@@@@', this.dataProducts);
     console.log('in buying history$$$$$$$$$$$$$$$', data);
   });
console.log('data store in products', this.products);
console.log('storage value is +++++of total', sessionStorage.setItem('count', this.products.length));
this.currentUser = this.helper.decodeToken(localStorage.getItem('token'));
console.log(this.helper.decodeToken(localStorage.getItem('token')));
}
totalPrice() {
 let total = 0;
  for (let count = 0; count < this.products.length; count++) {
      total +=  Number(this.products[count].price);
      console.log(total);
      sessionStorage.setItem('price', total.toString());
  }
  return total;
 }
continue3() {
  this.route.navigate(['/' , 'continue']);
}
buy3() {
  this.route.navigate(['/' , 'buy']);
}
remove3(product) {
   console.log('###########$$$######', product);
    this.db.list('/products/' + product.key).remove();
    console.log('**************');
  }
}
