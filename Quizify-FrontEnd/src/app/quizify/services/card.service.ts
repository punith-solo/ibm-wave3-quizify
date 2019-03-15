import { HttpClient } from '@angular/common/http';
 import { Injectable } from '@angular/core';
 import { Subject, Observable } from 'rxjs';
import { Game } from '../tsclasses/game';

@Injectable()
export class CardService {
    url: any;
    response: any;
      constructor(private http: HttpClient) {
    }

  //  getQuizGames() {
  //   this.url = 'http://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/game/';
  //   return this.http.get(this.url);

  //  }
   getMovieQuiz() {
    this.url = 'https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/game/topic/name/Movie';

    return this.http.get(this.url);

   }
   getTVShowQuiz() {
    this.url = 'https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/game/topic/name/TV shows';
    return this.http.get(this.url);

   }
   getCapitalsQuiz() {
    this.url = 'https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/game/topic/name/Capitals';
    return this.http.get(this.url);

   }
   getPresidentsQuiz() {
    this.url = 'https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/game/topic/name/Presidents';
    return this.http.get(this.url);
   }
}






