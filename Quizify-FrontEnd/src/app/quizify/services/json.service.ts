import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JsonService {

  constructor(private http: HttpClient) { }

  getCategoryFromJsonServer()
  {
    return this.http.get('https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/category/');
  }

  getTopicFromJsonServer() {
    return this.http.get('https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/topic/');
  }

  getGenreFromJsonServer()
  {
    return this.http.get('https://quizify-zuul.stackroute.io/recommendation-service/rest/neo4j/genre/');
  }

  getSinglePlayerFromJsonServer()
  {
    return this.http.get('http://localhost:3000/game');
  }
}
