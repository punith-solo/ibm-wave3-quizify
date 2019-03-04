import { Component, OnInit } from '@angular/core';
import { GameEngineService } from '../../services/game-engine.service';

@Component({
  selector: 'app-gamedetails',
  templateUrl: './gamedetails.component.html',
  styleUrls: ['./gamedetails.component.scss']
})

export class GamedetailsComponent implements OnInit {

  method: any;
  constructor(private gameengineservice: GameEngineService) { }

  quiz: any;

  ngOnInit() {
 }
 fetchGameId(gameId: number) {
  this.gameengineservice.fetchGame(gameId);
 }


}
