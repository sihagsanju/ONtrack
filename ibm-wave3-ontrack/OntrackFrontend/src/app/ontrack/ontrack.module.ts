import { OrderComponent } from './components/order/order.component';
import { BuyingHistoryComponent } from './components/buying-history/buying-history.component';
import { ProfileComponent } from './components/profile/profile.component';
import { BuyComponent } from './components/buy/buy.component';
import { HeaderComponent } from './components/header/header.component';
import { CartComponent } from './components/cart/cart.component';
import { SearchComponent } from './components/search/search.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpModule } from '@angular/http';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
// import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule, MatIconModule, MatLabel, MatDialogModule, MatDialogRef, MAT_DIALOG_DATA, MatRadioModule } from '@angular/material';
import { OntrackMaterialModule } from './ontrack.material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardComponent } from './components/card/card.component';
import { RegistrationcompComponent } from './components/registrationcomp/registrationcomp.component';
import { DailogComponent } from './components/dailog/dailog.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { BrowserModule } from '@angular/platform-browser';
import { MatInputModule } from '@angular/material';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { NavbarModule, WavesModule, ButtonsModule } from 'angular-bootstrap-md';
// For MDB Angular Pro
import { Ng2CarouselamosModule } from 'ng2-carouselamos';

import { PaymentComponent } from './components/payment/payment.component';


 @NgModule({
  // tslint:disable-next-line:max-line-length
  declarations: [HomeComponent, CardComponent, SearchComponent, RegistrationcompComponent, DailogComponent, CartComponent, HeaderComponent, LoginComponent, BuyComponent, ProfileComponent, BuyingHistoryComponent, PaymentComponent, OrderComponent],

 imports: [
  CommonModule,
  HttpClientModule,
  HttpModule,
  MatCardModule,
  OntrackMaterialModule,
  BrowserAnimationsModule,
  BrowserModule,
  FlexLayoutModule,
  ReactiveFormsModule,
  FormsModule,
  MatProgressSpinnerModule, MatRadioModule,
  MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    Ng2CarouselamosModule,
    NavbarModule

  ],

  providers: [{ provide: MatDialogModule, useValue: {} },
    { provide: MatIconModule, useValue: [] },
    {
       provide: MatLabel, useValue: {}
    },
    { provide: MatDialogRef, useValue: {} },
    {
      provide: MAT_DIALOG_DATA, useValue: {}
    }
     ],
    entryComponents: [
      DailogComponent,
    ],


  // tslint:disable-next-line:max-line-length
  exports: [HomeComponent, CardComponent, SearchComponent, DailogComponent, RegistrationcompComponent, CartComponent, HeaderComponent, LoginComponent, BuyComponent, BuyingHistoryComponent, PaymentComponent, OrderComponent]

})
export class OntrackModule { }
