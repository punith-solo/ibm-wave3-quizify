// import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Profile } from '../tsclasses/profile';
import { Observable } from 'rxjs/internal/Observable';
// import { Observable } from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class UserProfileService {
  microServiceUrl: string;

  constructor(private http: HttpClient) {}
  
  profile(userId: String) {
    this.microServiceUrl = 'http://localhost:8999/api/v1/user/' + userId;
    return this.http.get(this.microServiceUrl);
    }
}