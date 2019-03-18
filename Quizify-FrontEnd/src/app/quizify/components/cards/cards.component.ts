import { CardService } from './../../services/card.service';
import { Component, OnInit, ViewEncapsulation } from '@angular/core' ;
import { GameEngineService } from '../../services/game-engine.service';
import { RootContext } from '@angular/core/src/render3/interfaces/view';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { DialogComponent } from '../dialog/dialog.component';
import { SearchService } from '../../services/search.service';
import { Game } from '../../tsclasses/game';
import * as jwt_decode from 'jwt-decode';
import { LoginToken } from '../../tsclasses/login-token';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class CardsComponent implements OnInit {
  loginToken: any;
  aud: String;
  reg: Object;

  constructor(private cardService: CardService , private gameengineservice: GameEngineService, private searchService: SearchService,
    private router: Router, public dialog: MatDialog) { }
  method: any;
  quizGame: Game;
  dialogResult: any;
  games: Game[];
  gamesMovies: Game[];
  gamesTVShows: Game[];
  gamesPresidents: Game[];
  gamesCapitals: Game[];
  gamesLanguages: Game[];
  i: number;
  j: number;

  ngOnInit() {
    // this.cardService.getQuizGames().subscribe( (res: any) => {
    //   console.log(res);
    //   this.i = 0;
    //   this.j = 0;
    //   this.games = res;
    //   this.quizGame = this.games[0];
    //   console.log(this.quizGame);
    // });
    // for (const game of this.games) {
    //   if (game.topic.name === 'Movies') {
    //       this.gamesMovies[this.i++] = game;
    //   }
    //    if (game.topic.name === 'TV Shows') {
    //     this.gamesTVShows[this.j++] = game;
    //   }
    // }
    this.cardService.getCapitalsQuiz().subscribe((res: any) => {
      this.gamesCapitals = res;
    });
    this.cardService.getMovieQuiz().subscribe((res: any) => {
      this.gamesMovies = res;
    });
    this.cardService.getPresidentsQuiz().subscribe((res: any) => {
      this.gamesPresidents = res;
    });
    this.cardService.getTVShowQuiz().subscribe((res: any) => {
      this.gamesTVShows = res;
    });
    this.cardService.getLanguagesQuiz().subscribe((res: any) => {
      this.gamesLanguages = res;
    });
  }
  fetchGameId(gameId: number) {
    console.log(gameId);
    this.router.navigate(['playgame', {id : gameId}]);
   }

   likesGame(gameName: number) {
    console.log(gameName);
    try {
      const tokenObtained = localStorage.getItem('token');
      this.loginToken = jwt_decode(tokenObtained);
      console.log('decoded token', jwt_decode(tokenObtained));
      this.aud = this.loginToken.aud;
      console.log("username : " + this.aud);
      console.log('decoded token id', this.loginToken.jti);
      this.cardService.likesGame(gameName, this.aud).subscribe(data => {
        this.reg = data;
        // console.log(res);
        console.log( this.reg);
     });
      } catch (error) {
        console.log(error);
      }
   }

   openDialog(q) {
    const dialogRef = this.dialog.open(DialogComponent,  {
      data: { q }
   });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      this.dialogResult = result;
    });
  }
}
