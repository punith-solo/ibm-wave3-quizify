
import { LoginComponent } from './quizify/components/login/login.component';
import { ProfileComponent } from './quizify/components/profile/profile.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileuserComponent } from './quizify/components/profileuser/profileuser.component';
import { GamehistoryComponent } from './quizify/components/gamehistory/gamehistory.component';
import { GameComponent } from './quizify/components/game/game.component';
import { RegisterComponent } from './quizify/components/register/register.component';
import { CardsComponent } from './quizify/components/cards/cards.component';
import { SearchComponent } from './quizify/components/search/search.component';
import { QuestionGeneratorComponent } from './quizify/components/question-generator/question-generator.component';


const routes: Routes = [
   { path: 'profile' , component: ProfileComponent },
  {path: 'login', component: LoginComponent},
 { path: 'profileuser', component: ProfileuserComponent },

  { path: 'gamehistory', component: GamehistoryComponent },

  {path: 'game', component: GameComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'register', component: LoginComponent},
  {path: 'cards', component: CardsComponent},
  {path: 'search', component: SearchComponent},
  { path: 'question', component: QuestionGeneratorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
