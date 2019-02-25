import { logging } from 'protractor';
import { Component, OnInit } from '@angular/core';
// import { SharedServiceService } from "./quizify/services/shared-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'quizify-frontend';
  interests = ['Movies', 'TvShows'];
}
