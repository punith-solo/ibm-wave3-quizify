import { Component, OnInit } from '@angular/core';
import { SearchService } from '../../services/search.service';
import { Gamesearch } from '../../tsclasses/gamesearch';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  flag: boolean;
  userLogged: boolean;
  private games: Gamesearch[];
   constructor(private searchService: SearchService ,  private authenticationService: AuthenticationService) { }
ngOnInit() {

  if (localStorage.getItem('token') !== null ) {
    this.flag = true;
   this.userLogged = false;
  } else {

    this.flag = false;
   this.userLogged = true;
     }
}

  logout() {
      this.authenticationService.logout();
       this.flag = false;
       this.userLogged = true;
     // location.reload();
    }
  search(value) {
    this.searchService.searchByTopicStartsWith(value).subscribe((res: any) => {
      this.games = res.body[0].game;
      console.log(this.games);
    });
  }
}
