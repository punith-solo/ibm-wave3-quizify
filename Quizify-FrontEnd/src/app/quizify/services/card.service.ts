import { HttpClient } from '@angular/common/http';
 import { Injectable } from '@angular/core';
 import { Subject, Observable } from 'rxjs';

@Injectable()
export class CardService {
    url: any;
    response: any;
      constructor(private http: HttpClient) {
    }
   getQuizGames() {
    this.url = 'http://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/game/';
    return this.http.get(this.url);
   }

}






