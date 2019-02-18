import { GamehistoryComponent } from './components/gamehistory/gamehistory.component';
import { ProfileuserComponent } from './components/profileuser/profileuser.component';
import { MatRadioModule } from '@angular/material/radio';
import { RegisterComponent } from './components/register/register.component';
import { QuizifyMaterialModule } from './quizify.material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './components/profile/profile.component';
import { CardsComponent } from './components/cards/cards.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatCardModule, MatCardHeader, MatFormField, MatFormFieldModule, MatInputModule, MatButtonModule } from '@angular/material';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { SearchComponent } from './components/search/search.component';
import { GameComponent } from './components/game/game.component';
import { QuestionGeneratorComponent } from './components/question-generator/question-generator.component';
import { HeaderComponent } from './components/header/header.component';

import { BrowserModule } from '@angular/platform-browser';
@NgModule({
  declarations: [ CardsComponent,
    ProfileComponent,
    RegisterComponent,
    LoginComponent,
    SearchComponent,
    ProfileuserComponent,
    GamehistoryComponent,
    GameComponent,
    QuestionGeneratorComponent,
    HeaderComponent
     ],

  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatCardModule,
    QuizifyMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    BrowserModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule


  ],
  exports: [ CardsComponent,
    ProfileComponent,
    RegisterComponent,
    LoginComponent,
    SearchComponent,
    ProfileuserComponent,
    GamehistoryComponent,
    GameComponent,
    QuestionGeneratorComponent
   ]

})
export class QuizifyModule { }
