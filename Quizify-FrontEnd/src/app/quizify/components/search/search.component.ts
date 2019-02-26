import { Router } from '@angular/router';
import { Component, OnInit, Input } from '@angular/core';
import { Gamesearch } from '../../tsclasses/gamesearch';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  @Input() game: Gamesearch; 

  constructor(private router: Router) { }

  ngOnInit() {
  }
  // openSearch() {
  //   this.router.navigate(['profile']);
  // }

}
