import { Router } from '@angular/router';
import { Component, OnInit, Input, Inject } from '@angular/core';
import { Gamesearch } from '../../tsclasses/gamesearch';
import { SearchService } from '../../services/search.service';
import { GameEngineService } from '../../services/game-engine.service';
import { MatDialog } from '@angular/material';
import { DialogComponent } from '../dialog/dialog.component';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  Gamesearch: any;
  private game: Gamesearch[];
  q: any;
  dialogResult: any;
  constructor(private router: Router, private searchService: SearchService,
     public dialog: MatDialog, private gameengineservice: GameEngineService) { }

  ngOnInit() {

  }
  fetchGameId(gameId: number) {
    this.gameengineservice.fetchGame(gameId);
   }


  search(value) {
    if (value === '') {
      this.game = null;
    } else {
    this.searchService.searchByTopicStartsWith(value).subscribe((res: any) => {
      this.game = res.body;
      console.log(res);
      console.log(this.game);
    });
  }

    }
  // search(value) {
  //   this.searchService.searchByTopicStartsWith(value).subscribe((res: any) => {
  //     this.game = res.body[0].game;
  //     console.log(this.game);
  //   });
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
