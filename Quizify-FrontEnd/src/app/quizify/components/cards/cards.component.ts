import { CardService } from './../../services/card.service';
import { Component, OnInit } from '@angular/core' ;
import { GameEngineService } from '../../services/game-engine.service';
import { RootContext } from '@angular/core/src/render3/interfaces/view';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.scss']
})
export class CardsComponent implements OnInit {


  constructor(private router: Router, private cardService: CardService ) { }
  method: any;
  quiz: any;

  ngOnInit() {
    for (let i = 0; i < 2; i++) {
    this.cardService.getquiz().subscribe(resposeQuiz => this.quiz = resposeQuiz);
    }
  }
  fetchGameId(gameId: number) {
    console.log(gameId);
    this.router.navigate(['playgame', {id : gameId}]);
   }
}
