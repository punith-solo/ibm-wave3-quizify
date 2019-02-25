// import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { of, from , Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedServiceService {

  constructor() { }

   loggedIn = new Subject();
}
