import { Component, OnInit } from '@angular/core';
import { Admin } from '../../tsclasses/admin';
import { Category } from '../../tsclasses/category';
import { Topic } from '../../tsclasses/topic';
import { Question } from '../../tsclasses/question';
import { Type } from '@angular/compiler';
import { Level } from '../question-generator/question-generator.component';
import { Game } from '../../tsclasses/game';
import { User } from '../../tsclasses/user';

@Component({
  selector: 'app-singleplayer',
  templateUrl: './singleplayer.component.html',
  styleUrls: ['./singleplayer.component.scss']
})
export class SingleplayerComponent implements OnInit {
  private game: Game;
  private statusCode: number;
  private question: Question;
  private questions: Question[];
  private user: User;

  constructor() { }

  ngOnInit() {
  }



}
