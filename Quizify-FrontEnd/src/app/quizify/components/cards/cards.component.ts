import { CardService } from './../../services/card.service';
import { Component, OnInit } from '@angular/core' ;
import { GameEngineService } from '../../services/game-engine.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.scss']
})
export class CardsComponent implements OnInit {


  constructor(private cardService: CardService , private gameengineservice: GameEngineService) { }
  method: any;
  quiz: any;

  ngOnInit() {
    for (let i = 0; i < 2; i++) {
    this.cardService.getquiz().subscribe(resposeQuiz => this.quiz = resposeQuiz);
    }
  }
  fetchGameId(gameId: number) {
    this.gameengineservice.fetchGame(gameId);
   }
}
