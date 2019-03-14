import { Component, OnInit, Input, ViewEncapsulation, ViewChild } from '@angular/core';

import { GameEngineService } from '../../services/game-engine.service';

import { Game } from '../../tsclasses/game';

import { ActivatedRoute } from '@angular/router';

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

  @ViewChild('stepper') stpr: MatStepper;  


  constructor( 
    private route: ActivatedRoute,
    private gameengineservice: GameEngineService,
    private snackBar: MatSnackBar,
    private jsonServer: JsonService
    ) {
      this.firstQuestion = true;
      this.lastQuestion = false;
      this.timeBar = 100;
      this.math = Math;
     }
  ngOnInit() {
    this.singlePlayer = new SinglePlayer();
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
        // this.jti = 123;
        this.gameengineservice.fetchGame(this.gameId , 'guest').subscribe((res: any) => {
          console.log(res);
            // this.singlePlayer.playerId = res.body.playerName;
            this.game = res.body.game;
  
            this.questions = this.game.questions;
            this.startTimeBar(this.game.timeDuration);
            // this.startTimer(this.game.timeDuration);
            this.currentQuestionNumber = 1;
            if(this.game.level === 'easy')
              this.scorePerQuetsion = 1;
            else if(this.game.level === 'medium')
              this.scorePerQuetsion = 2;
            else if(this.game.level === 'hard')
              this.scorePerQuetsion = 3;
            
            this.gameScore = this.game.numOfQuestion * this.scorePerQuetsion;
            this.playerScore = 0;
            this.gameFinished = false;
            this.playerAttempted = 0;
            this.playerAttemptedRight = 0;
            this.playerAttemptedWrong = 0;
        });

        // this.jsonServer.getSinglePlayerFromJsonServer().subscribe((res: any) => {
        //   // console.log(res);
        //   // this.singlePlayer.playerId = res.body.playerId;
        //   this.game = res[0].game;

        //   this.questions = this.game.questions;
        //   this.startTimeBar(this.game.timeDuration);
        //   // this.startTimer(this.game.timeDuration);
        //   this.currentQuestionNumber = 1;
        //   if(this.game.level === 'easy')
        //     this.scorePerQuetsion = 1;
        //   else if(this.game.level === 'medium')
        //     this.scorePerQuetsion = 2;
        //   else if(this.game.level === 'hard')
        //     this.scorePerQuetsion = 3;
          
        //   this.gameScore = this.game.numOfQuestion * this.scorePerQuetsion;
        //   this.playerScore = 0;
        //   this.gameFinished = false;
        //   this.playerAttempted = 0;
        //   this.playerAttemptedRight = 0;
        //   this.playerAttemptedWrong = 0;
        // });
      }
    });
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
    }
    else
    {
      this.snackBar.open('Question Already Attempted !', '', {
        duration: 1000
      });
    }

  }

  // startTimer(timeDuration: number) {
  //   this.timeLeft = timeDuration;
  //   setInterval(() => {
  //     if (this.timeLeft > 0)
  //     {
  //       this.timeLeft--;
  //     }
  //     // console.log('time started');
  //   }, 1000);
  // }

  startTimeBar(timeDuration: number) {
    this.timeLeft = timeDuration;
    timeDuration *= 100;
    let timeLeft = timeDuration;
    let counter = 0;
    const timer = setInterval(() => {
      if (timeLeft > 0)
      {
        timeLeft--;
        counter++;
        this.timeBar = (timeLeft/timeDuration)*100;
      }
      else 
      {
        this.gameFinished = true;
        clearInterval(timer);
        this.stpr.selectedIndex = this.game.numOfQuestion;
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

}
