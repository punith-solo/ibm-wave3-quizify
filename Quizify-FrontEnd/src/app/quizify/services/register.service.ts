import { Injectable, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Register } from '../tsclasses/register';
@Injectable({
   providedIn: 'root'
})
export class RegisterService {

   url: string;
      topicUrl: string;
      genreUrl: string;
      response: any;
      get: any;
   constructor(private http: HttpClient) { }
   addUser(register: Register) {
      // this.url = 'http://0.0.0.0:8999/api/v1/user/';
     this.url = 'https://quizify-zuul.stackroute.io/user-registration-service/api/v1/user/';
         this. http.get(this.url).subscribe(resp => {
            this.response = resp;
         });
         return this.http.post(this.url + '' , register, {observe: 'response', responseType: 'text' });
   }
   getTopic() {
      // this.topicUrl = 'http://localhost:3000/topic';
      this.topicUrl ='https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/topic/';
      return this.http.get(this.topicUrl);
   }
   getGenre() {
      // this.genreUrl = 'http://localhost:3000/genre';
      this.genreUrl = 'https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/genre/';
      return this.http.get(this.genreUrl);
   }
   profile(userId: string) {
      this.url = 'https://quizify-zuul.stackroute.io/user-registration-service/api/v1/user/' + userId;
      return this.http.get(this.url);
      }
}
