import { ProfileUserComponent } from './quizify/components/profileuser/profileuser.component';
import { HeaderComponent } from './quizify/components/header/header.component';

import { LoginComponent } from './quizify/components/login/login.component';
import { ProfileComponent } from './quizify/components/profile/profile.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GamehistoryComponent } from './quizify/components/gamehistory/gamehistory.component';
import { RegisterComponent } from './quizify/components/register/register.component';
import { CardsComponent } from './quizify/components/cards/cards.component';
import { SearchComponent } from './quizify/components/search/search.component';
import { GamedetailsComponent } from './quizify/components/gamedetails/gamedetails.component';
import { AuthGuard } from './quizify/components/auth/auth.guard';
import { GameEngineComponent } from './quizify/components/game-engine/game-engine.component';
import { RuleComponent } from './quizify/components/rule/rule.component';
import { AdminGameLandingComponent } from './quizify/components/admin-game-landing/admin-game-landing.component';
import { AddQuestionComponent } from './quizify/components/add-question/add-question.component';
import { AddGameComponent } from './quizify/components/add-game/add-game.component';


const routes: Routes = [
  { path: 'profile' , component: ProfileComponent },
 {path: 'login', component: LoginComponent},
 { path: 'profileuser', component: ProfileUserComponent },
 { path: 'playgame' , component: GameEngineComponent},

  { path: 'gamehistory', component: GamehistoryComponent },

  { path: 'gamedetails', component: GamedetailsComponent},
  {path: 'add-game', component: AddGameComponent},
  {path: 'register', component: RegisterComponent},
  { path: 'login', component: CardsComponent},
  { path: 'add-question', component: AddQuestionComponent },
  { path: 'adminpage', component: AdminGameLandingComponent, canActivate: [AuthGuard] },
  { path: 'rule', component: RuleComponent},
  { path: '**', component: CardsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
