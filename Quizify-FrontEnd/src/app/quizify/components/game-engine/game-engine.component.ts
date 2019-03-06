import { Component, OnInit, Input } from '@angular/core';
import { GameEngineService } from '../../services/game-engine.service';
import { Game } from '../../tsclasses/game';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-game-engine',
  templateUrl: './game-engine.component.html',
  styleUrls: ['./game-engine.component.scss']
})
export class GameEngineComponent implements OnInit {
  @Input() gameId: number;

  private game: Game;

  constructor( private route: ActivatedRoute , private gameengineservice: GameEngineService) { }

  ngOnInit() {

    this.route.params.subscribe((data: any) => {
      this.gameId = data.id;
      console.log(this.gameId);
          this.gameengineservice.fetchGame(this.gameId).subscribe((res: any) => {
            this.game = res;
            console.log(res);
            console.log(this.game.numOfQuestion);
            console.log(this.game.questions);
            console.log(this.game.id);
            console.log(this.game.genre);
            console.log(this.game.numOfQuestion);
          // console.log(this.game);
            });
      });
  }

}
