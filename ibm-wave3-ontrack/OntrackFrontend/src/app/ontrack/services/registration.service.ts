import { Injectable, Input } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Myregistration } from '../classes/Myregistration';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  url: string;
   response: any;
   get: any;
   httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
constructor(private http: HttpClient ) {}
addregister(reg: Myregistration) {
  console.log(reg);
  this.url = 'https://shoefly-zuul.stackroute.io/user-registration-service/api/v1/user';
  return this.http.post(this.url, JSON.stringify(reg) , this.httpOptions);
 }
 profile(userId: String) {
  this.url = 'https://shoefly-zuul.stackroute.io/user-registration-service/api/v1/user/' + userId;
  return this.http.get(this.url);
 }
}
