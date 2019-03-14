import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';

@Injectable()
export class GamedetailsService {
  url: any;
  response: any;

  constructor(private http: HttpClient) {   }

  getDetails() {
      this.url = 'http://13.232.243.68:8092/rest/neo4j/games/mostplayed';
      return this.http.get(this.url);
  }
}
