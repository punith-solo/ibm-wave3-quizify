import { Injectable } from '@angular/core';
import { SinglePlayer } from '../tsclasses/single-player';
import { catchError } from 'rxjs/operators';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SingleplayerService {


  private  microServiceUrl: string;

  private singlePlayer: SinglePlayer;

  private errorMsg: string;
  private errorStatus: string;
  private errorBody: string;

  constructor(private http: HttpClient) {
    this.microServiceUrl = 'http://13.232.243.68:8108/single-player-service/';
   }

   savePlayer(singlePlayer: SinglePlayer) {
     console.log(singlePlayer);
     return this.http
    .post(this.microServiceUrl + '/singleplayer', singlePlayer, { observe: 'response' });
   }

   fetchGameHistory(gameName: string) {
    return this.http
   .get(this.microServiceUrl + 'categories/' + gameName, { observe: 'response' });
   }
}
