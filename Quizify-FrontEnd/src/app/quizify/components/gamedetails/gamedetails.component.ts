import { Component, OnInit } from '@angular/core';
import { GamedetailsService } from '../../services/gamedetails.service';
import { SinglePlayer } from '../../tsclasses/single-player';
import { Game } from '../../tsclasses/game';
import { GameEngineService } from '../../services/game-engine.service';
import { MatSnackBar } from '@angular/material';

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
