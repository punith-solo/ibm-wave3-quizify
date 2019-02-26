import { Component, OnInit } from '@angular/core';
import { GamedetailsService } from '../../services/gamedetails.service';
import { single } from 'rxjs/operators';
import { SinglePlayer } from '../../tsclasses/single-player';
import { Game } from '../../tsclasses/game';
import { SingleplayerService } from '../../services/singleplayer.service';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'app-gamedetails',
  templateUrl: './gamedetails.component.html',
  styleUrls: ['./gamedetails.component.scss']
})

export class GamedetailsComponent implements OnInit {
  private singleplayer: SinglePlayer;
  private game: Game;
  private statusCode: number;


  method: any;
  constructor(private singleplayerservice: SingleplayerService, private snackBar: MatSnackBar) { }
  quiz: any;
  ngOnInit() {
 }

  fetchGameId(gameId: string) {
    this.game.name = gameId;
    this.singleplayer.game = this.game;
    this.savePlayer(this.singleplayer);
  }

  savePlayer(singlePlayer: SinglePlayer) {
    this.singleplayerservice.savePlayer(singlePlayer).subscribe(
      response => {
        this.statusCode = response.status;
        if (this.statusCode === 200) {
          console.log('Success', this.statusCode);
          this.snackBar.open('Question Successfully Saved !!!', '', {
            duration: 1500
          });
        }
      },
      err => {
        const errorStatus = err;
        this.statusCode = parseInt(errorStatus, 10);
        if (this.statusCode === 409) {
          this.snackBar.open('Question Already Saved !!!', '', {
            duration: 1500
          });
          this.statusCode = 0;
        }
    });

  }
}
