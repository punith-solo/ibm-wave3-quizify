import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { SearchService } from '../../services/search.service';
import { Router } from '@angular/router';
import { GameserviceService } from '../../services/gameservice.service';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss']
})
export class DialogComponent implements OnInit {

  constructor(private router: Router, public dialogRef: MatDialogRef<DialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private searchService: SearchService) { }

  ngOnInit() {

  }
  fetchGameId(gameId: number) {
    console.log('it is game Id', gameId);
    this.router.navigate(['playgame', {id : gameId}]);
    // this.gameengineservice.fetchGame(gameId);
   }


}
