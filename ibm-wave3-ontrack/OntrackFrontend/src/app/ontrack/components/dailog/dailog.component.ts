import { Ontrack } from './../../classes/ontrack';
import { SearchService } from './../../services/search.service';
import { OnTrackService } from '../../services/ontrack.service';
import { Router } from '@angular/router';
import { Component, OnInit, Inject, Input, Output, EventEmitter} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { database } from 'firebase';
@Component({
  selector: 'app-dailog',
  templateUrl: './dailog.component.html',
  styleUrls: ['./dailog.component.scss']
})
export class DailogComponent implements OnInit {
  products: any = [];
  Ontrack: any = [];
  constructor(
    public dialogRef: MatDialogRef<DailogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private onTrack: OnTrackService, private searchService: SearchService, public route: Router
    ) {}

      @Input()
      o: any;
      q: any;
      cart: any ;
      @Output()
       cartAddEvent = new EventEmitter<any>();
      dialogResult: any;
      AddToCart(o): void {
        console.log(o, 'click event call');
        this.cartAddEvent.emit(o);
        this.onTrack.cart = o;
       this.route.navigateByUrl('/AddToCarts');
      }
    ngOnInit() {
      this.onTrack.openDailog().subscribe(data => {
        this.products = data;
      });
      this.searchService.openDailog().subscribe(res => {
        this.Ontrack = res;
      });
    }
  closeDailog() {
    this.dialogRef.close('');
  }
  buy1() {
    this.route.navigate(['/' , 'buy1']);
  }
  AddtoCart() {
    this.route.navigate(['/' , 'AddtoCart']);
  }
}

