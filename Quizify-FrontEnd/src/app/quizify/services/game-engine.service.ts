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
    this.microServiceUrl = 'http://13.232.243.68:8108/single-player-engine/api/v1/';
   }

   fetchGame(gameId: number) {
    console.log(gameId);
      console.log( this.http
     .get(this.microServiceUrl + 'game/' + gameId, { observe: 'response' }));
    }
}
