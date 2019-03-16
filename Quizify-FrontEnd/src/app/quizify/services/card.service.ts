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
    this.url = 'https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/game/topic/name/Movies';
    return this.http.get(this.url);

   }
   getTVShowQuiz() {
    this.url = 'https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/game/topic/name/TV Shows';
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
   getLanguagesQuiz() {
    this.url = 'https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/game/topic/name/Languges';
    return this.http.get(this.url);
   }

   likesGame(gameName: number, userName: String){
      this.url='https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/likes/user/';
      // this.url = 'http://localhost:8104/rest/neo4j/likes/user/';
      console.log(this.url + userName + '/game/' + gameName);
      return this.http.post(this.url + userName + '/game/' + gameName, { observe: 'response' });
   }
}






