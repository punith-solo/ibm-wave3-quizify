import { Injectable } from '@angular/core';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { SinglePlayer } from '../tsclasses/single-player';

@Injectable({

  providedIn: 'root'

})

export class GameEngineService {

  private  microServiceUrl: string;

  private singlePlayer: SinglePlayer;

  private errorMsg: string;

  private errorStatus: string;

  private errorBody: string;
  url: string;

  constructor(private http: HttpClient) {

    this.microServiceUrl = 'https://quizify-zuul.stackroute.io/single-player-engine/api/v1/singlePlayer/';

   }

   fetchGame(gameId: number, userName: any) {

     console.log(this.microServiceUrl + userName + '/game/' + gameId);

    return this.http

     .get(this.microServiceUrl + userName + '/game/' + gameId, { observe: 'response' });

    }

    submitGame(singlePlayer: SinglePlayer) {
      return this.http
     .post(this.microServiceUrl , singlePlayer, { observe: 'response' });
    }

    recommendGames(gameId: number, playerScore: number) {
      this.url = 'https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/game/level/';
      console.log(this.url + gameId + '/' + playerScore);
      return this.http.get(this.url + gameId + '/' + playerScore, { observe: 'response' });
    }
}
