
import { OnTrackService } from './ontrack/services/ontrack.service';
import { FlexLayoutModule } from '@angular/flex-layout';

import { MatDialogModule } from '@angular/material/dialog';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OntrackModule } from './ontrack/ontrack.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { OntrackserviceService } from './ontrack/services/ontrackservice.service';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './ontrack/services/login.service';
import { SearchService } from './ontrack/services/search.service';
import { AngularFirestoreModule } from '@angular/fire/firestore';
import { AngularFireStorageModule } from '@angular/fire/storage';
import { AngularFireAuthModule, AngularFireAuth } from '@angular/fire/auth';
import { AngularFireDatabase } from '@angular/fire/database';
import { environment } from 'src/environments/environment';
import { AngularFireModule } from 'angularfire2';
import { OntrackMaterialModule } from './ontrack/ontrack.material.module';
import { DatePipe } from '@angular/common';



@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    OntrackModule,
    OntrackMaterialModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    FlexLayoutModule,
    AngularFireModule.initializeApp(environment.firebase, 'E-Commerce'), // imports firebase/app needed for everything
  AngularFirestoreModule, // imports firebase/firestore, only needed for database features
  AngularFireAuthModule, // imports firebase/auth, only needed for auth features,
  AngularFireStorageModule // imports firebase/storage only needed for storage features
  ],
  // tslint:disable-next-line:max-line-length
  providers: [OntrackserviceService, SearchService, OnTrackService, LoginService, AngularFireAuth, AngularFireDatabase,  AngularFireStorageModule, AngularFireModule, AngularFirestoreModule, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
