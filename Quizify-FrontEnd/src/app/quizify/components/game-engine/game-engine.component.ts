import { Component, OnInit, Input, ViewEncapsulation, ViewChild } from '@angular/core';

import { GameEngineService } from '../../services/game-engine.service';

import { Game } from '../../tsclasses/game';

import { ActivatedRoute, Router } from '@angular/router';

import * as jwt_decode from 'jwt-decode';

import { User } from '../../tsclasses/user';

import { LoginToken } from '../../tsclasses/login-token';

import { SinglePlayer } from '../../tsclasses/single-player';
import { Question } from '../../tsclasses/question';
import { MatStepper } from '@angular/material/stepper';
import { MatSnackBar, MatChip, MatChipList } from '@angular/material';
import { JsonService } from '../../services/json.service';

@Component({

  selector: 'app-game-engine',

  templateUrl: './game-engine.component.html',

  styleUrls: ['./game-engine.component.scss'],
  encapsulation: ViewEncapsulation.None

})

export class GameEngineComponent implements OnInit {

  @Input() gameId: number;

  loginToken: LoginToken;

  jti: number;
  aud: string;

  private singlePlayer: SinglePlayer;

  private game: Game;
  private questions: Question[];
  private firstQuestion: boolean;
  private lastQuestion: boolean;
  private timeLeft: number;
  private timeBar: number;
  private math: any;
  private currentQuestionNumber: number;
  private scorePerQuetsion: number;
  private gameScore: number;
  private playerScore: number;
  private gameFinished: boolean;
  private playerAttempted: number;
  private playerAttemptedRight: number;
  private playerAttemptedWrong: number;
  private playerName: string;
  private resultStar: string[];
  private redStar = '../../../../assets/images/red-star.jpg';
  private blackStar = '../../../../assets/images/black-star.jpg';
  private timer: any;
  private lastQuestionAttempted: boolean;
  private gameLoaded: boolean;
  private loading:any = true;
  private gamesList: Game[];
  @ViewChild('stepper') stpr: MatStepper;  
  


  constructor( 
    private route: ActivatedRoute,
    private gameengineservice: GameEngineService,
    private snackBar: MatSnackBar,
    private jsonServer: JsonService,
    private router: Router
    ) {
      this.firstQuestion = true;
      this.lastQuestion = false;
      this.timeBar = 100;
      this.math = Math;
      this.gameLoaded = false;
     }
  ngOnInit() {
    this.startUp();
  }

  startUp() {
    this.gameLoaded = false;
    this.singlePlayer = new SinglePlayer();
    this.route.params.subscribe((data: any) => {
      this.gameId = data.id;
      console.log(this.gameId);
      try {
        const tokenObtained = localStorage.getItem('token');
        this.loginToken = jwt_decode(tokenObtained);
        console.log('decoded token', jwt_decode(tokenObtained));
        this.jti = this.loginToken.jti;
        this.aud = this.loginToken.aud;
        console.log('decoded token id', this.loginToken.jti);
        this.gameengineservice.fetchGame(this.gameId , this.aud).subscribe((res: any) => {
          this.startGame(res.body.playerName, res.body.game);
        } );
      } catch (error) {
        this.gameengineservice.fetchGame(this.gameId , 'Guest_Player').subscribe((res: any) => {
          this.startGame(res.body.playerName, res.body.game);
            
        });
      }
      this.resultStar = [this.blackStar, this.blackStar, this.blackStar, this.blackStar, this.blackStar];
    });

  }

  startGame(player:string, game:Game) {
    this.playerName = player;
            this.game = game;
            if(this.game !== undefined)
              this.gameLoaded = true;
  
            this.questions = this.game.questions;
            this.startTimeBar(this.game.timeDuration);
            this.currentQuestionNumber = 1;
            this.scorePerQuetsion = this.game.pointPerQuestion;
            this.gameScore = this.game.totalPoints;
            this.playerScore = 0;
            this.gameFinished = false;
            this.playerAttempted = 0;
            this.playerAttemptedRight = 0;
            this.playerAttemptedWrong = 0;
            this.lastQuestionAttempted = false;
            this.loading = false;
  }

  checkStepper(stepper: MatStepper) {
    if(stepper.selectedIndex+1 === 1)
      this.firstQuestion = true;
    else
      this.firstQuestion = false;

    if(stepper.selectedIndex+1 === this.game.numOfQuestion)
      this.lastQuestion = true;
    else
      this.lastQuestion = false;
  }

  nextStepper(stepper: MatStepper) {
    // console.log(stepper.selectedIndex);
    if(this.questions[stepper.selectedIndex].playerAnswer !== null)
    {
      this.checkStepper(stepper);
      if(stepper.selectedIndex+1 !== this.game.numOfQuestion)
      {
        stepper.next();
        this.currentQuestionNumber++;
      }
      this.checkStepper(stepper);
    }
    else
    {
      this.snackBar.open('Please Select An Option !', '', {
        duration: 1000
      });
    }
    
  }

  backStepper(stepper: MatStepper) {
    this.checkStepper(stepper);
    if(stepper.selectedIndex+1 !== 1)
    {
      stepper.previous();
      this.currentQuestionNumber--;
    }
    this.checkStepper(stepper);
  }

  selectdAnswer(questionNumber: number, optionNumber: number, chipList: MatChipList, event: any, emoji: any) {
    if(this.questions[questionNumber].playerAnswer === null)
    {
      this.playerAttempted++;
      this.questions[questionNumber].playerAnswer = this.questions[questionNumber].options[optionNumber];
  
      if(this.questions[questionNumber].correctAnswer.trim() === this.questions[questionNumber].playerAnswer.trim())
      {
        this.playerScore += this.scorePerQuetsion;
        event.target.classList.add('correct-answer');
        emoji.src = '../../../../assets/images/emojiRight';
        this.playerAttemptedRight++;
      }
      else
      {
        event.target.classList.add('wrong-answer');
        emoji.src = '../../../../assets/images/emojiWrong';
        this.playerAttemptedWrong++;
      }

      if(questionNumber+1 === this.game.numOfQuestion)
        this.lastQuestionAttempted = true;
    }
    else
    {
      this.snackBar.open('Question Already Attempted !', '', {
        duration: 1000
      });
    }

  }

  startTimeBar(timeDuration: number) {
    this.timeLeft = timeDuration;
    timeDuration *= 100;
    let timeLeft = timeDuration;
    let counter = 0;
    this.timer = setInterval(() => {
      if (timeLeft > 0)
      {
        timeLeft--;
        counter++;
        this.timeBar = (timeLeft/timeDuration)*100;
      }
      else 
      {
        this.gameFinished = true;
        clearInterval(this.timer);
        this.submitGame();
        
      }
      if(counter === 100)
      {
        if (this.timeLeft > 0)
          {
            this.timeLeft--;
          }
        counter = 0;
      }
    }, 10);
  }

  submitGame(){
    this.gameFinished = true;
    this.game.playerScore = this.playerScore;
    if(this.playerScore/this.game.totalPoints === 1 )
      this.resultStar = [this.redStar, this.redStar, this.redStar, this.redStar, this.redStar];
    else if(this.playerScore/this.game.totalPoints >= 0.8 )
      this.resultStar = [this.redStar, this.redStar, this.redStar, this.redStar, this.blackStar];
    else if(this.playerScore/this.game.totalPoints >= 0.6 )
      this.resultStar = [this.redStar, this.redStar, this.redStar, this.blackStar, this.blackStar];
    else if(this.playerScore/this.game.totalPoints >= 0.4 )
      this.resultStar = [this.redStar, this.redStar, this.blackStar, this.blackStar, this.blackStar];
    else if(this.playerScore/this.game.totalPoints >= 0.2 )
      this.resultStar = [this.redStar, this.blackStar, this.blackStar, this.blackStar, this.blackStar];
    this.stpr.selectedIndex = this.game.numOfQuestion;
    this.singlePlayer.playerName= this.playerName;
    this.singlePlayer.game = this.game;
    this.gameengineservice.submitGame(this.singlePlayer).subscribe((res: any) => {
      //
    });
    this.recommendGames(this.gameId);
  }

  rePlay() {
    clearInterval(this.timer);
    this.startUp();
    this.stpr.selectedIndex = 0;
  }

  recommendGames(gameId: number) {
    console.log(this.playerScore);
    this.gameengineservice.recommendGames(gameId, this.playerScore).subscribe((res: any) => {
      this.gamesList = res.body;
      console.log(res);
    });
    console.log(this.gamesList);
  }

}
