import { Component, OnInit } from '@angular/core';
import { GamedetailsService } from '../../services/gamedetails.service';

@Component({
  selector: 'app-gamedetails',
  templateUrl: './gamedetails.component.html',
  styleUrls: ['./gamedetails.component.scss']
})

export class GamedetailsComponent implements OnInit {

  method: any;  
  constructor(private gamedetailsService: GamedetailsService) { }
  
  quiz: any;
  
  ngOnInit() {
   this.gamedetailsService.getDetails().subscribe(resposeQuiz => this.quiz = resposeQuiz);
 }

}
