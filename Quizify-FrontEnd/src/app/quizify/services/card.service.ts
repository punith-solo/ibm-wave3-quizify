import { HttpClient } from '@angular/common/http';
 import { Injectable } from '@angular/core';
 import { Subject, Observable } from 'rxjs';

@Injectable()
export class CardService {
    url: any;
    response: any;
      constructor(private http: HttpClient) {
    }
   getquiz() {
    // this.url = 'http://localhost:3000/quiz';
    this.url = 'https://13.232.243.68:8104/recommendation-service/rest.neo4j/game/mostplayed';
    return this.http.get(this.url);
   }

}






