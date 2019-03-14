

// import { JwtHelperService } from '@auth0/angular-jwt';

import { QuizifyModule } from './quizify/quizify.module';
import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatCardModule } from '@angular/material';
import { MatDialogModule } from '@angular/material/dialog';

import {MatSelectModule} from '@angular/material/select';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { QuizifyMaterialModule } from './quizify/quizify.material.module';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HeaderComponent } from './quizify/components/header/header.component';
import { JsonService } from './quizify/services/json.service';
import { FormComponent } from './quizify/components/form/form.component';
import { AdminGameService } from './quizify/services/admin-game.service';
import { AdminQuestionService } from './quizify/services/admin-question.service';


@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    // HeaderComponent
  ],
  imports: [
    BrowserModule,
    QuizifyModule,
    AppRoutingModule,
    MatCardModule,
    MatSelectModule,
    BrowserAnimationsModule,
    HttpClientModule,
    QuizifyMaterialModule,
    MatDialogModule
      ],
  providers: [AdminGameService,
  AdminQuestionService, JsonService] ,
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],

  bootstrap: [AppComponent]
})
export class AppModule { }
