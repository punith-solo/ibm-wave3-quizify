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


}
