import { Component, OnInit, Input } from '@angular/core';

import { GameEngineService } from '../../services/game-engine.service';

import { Game } from '../../tsclasses/game';

import { ActivatedRoute } from '@angular/router';

import * as jwt_decode from 'jwt-decode';

import { User } from '../../tsclasses/user';

import { LoginToken } from '../../tsclasses/login-token';

import { SinglePlayer } from '../../tsclasses/single-player';

@Component({

  selector: 'app-game-engine',

  templateUrl: './game-engine.component.html',

  styleUrls: ['./game-engine.component.scss']

})

export class GameEngineComponent implements OnInit {

  @Input() gameId: number;

  loginToken: LoginToken;

  jti: number;

  private singlePlayer: SinglePlayer;

  private game: Game;



  constructor( private route: ActivatedRoute , private gameengineservice: GameEngineService) {
    this.singlePlayer = new SinglePlayer();
   }
  ngOnInit() {
    this.route.params.subscribe((data: any) => {
      this.gameId = data.id;
      console.log(this.gameId);
      try {
        const tokenObtained = localStorage.getItem('token');
        this.loginToken = jwt_decode(tokenObtained);
        console.log('decoded token', jwt_decode(tokenObtained));
        this.jti = this.loginToken.jti;
        console.log('decoded token id', this.loginToken.jti);
        this.gameengineservice.fetchGame(this.gameId , this.jti).subscribe((res: any) => {
          this.singlePlayer.playerId = res.jti;
          this.game = res.game;
        } );
      } catch (error) {
        this.jti = 777;
        this.gameengineservice.fetchGame(this.gameId , this.jti).subscribe((res: any) => {
          this.singlePlayer.playerId = res.jti;
          this.game = res.game;

        });

      }

      });

  }



}
