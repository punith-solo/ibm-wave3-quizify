import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { SinglePlayer } from '../tsclasses/single-player';


@Injectable({
  providedIn: 'root'
})
export class GameEngineService {

  private  microServiceUrl: string;

  private singlePlayers: SinglePlayer;

  private errorMsg: string;
  private errorStatus: string;
  private errorBody: string;

  constructor(private http: HttpClient) {
    this.microServiceUrl = 'http://13.232.243.68:8108/single-player-service/';
   }

   savePlayer(singlePlayers: SinglePlayer) {
     console.log(singlePlayers);
     return this.http
    .post(this.microServiceUrl + '/singleplayer', singlePlayers, { observe: 'response' });
   }

   fetchGameHistory(gameName: string) {
    return this.http
   .get(this.microServiceUrl + 'categories/' + gameName, { observe: 'response' });
   }
  }
