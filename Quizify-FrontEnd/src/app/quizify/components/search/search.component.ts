import { Router } from '@angular/router';
import { Component, OnInit, Input, Inject } from '@angular/core';
import { Gamesearch } from '../../tsclasses/gamesearch';
import { SearchService } from '../../services/search.service';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { DialogComponent } from '../dialog/dialog.component';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  Gamesearch: any;
  private games: Gamesearch[];
  q: any;
  dialogResult: any;
  constructor(private router: Router, private searchService: SearchService, public dialog: MatDialog) { }

  ngOnInit() {

  }

  search(value) {
    if (value === '') {
      this.games = null;
    } else {
    this.searchService.searchByTopicStartsWith(value).subscribe((res: any) => {
      this.games = res.body;
      console.log(res);
      console.log(this.games);
    });
  }
  }
  // search(value) {
  //   this.searchService.searchByTopicStartsWith(value).subscribe((res: any) => {
  //     this.games = res.body[0].game;
  //     console.log(this.games);
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
