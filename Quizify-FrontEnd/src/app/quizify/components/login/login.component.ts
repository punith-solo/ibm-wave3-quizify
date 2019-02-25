import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthenticationService } from './../../services/authentication.service';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router' ;
import { first } from 'rxjs/operators' ;
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';

import { SharedServiceService } from '../../services/shared-service.service';
import { EventHandlerVars } from '@angular/compiler/src/compiler_util/expression_converter';
// import { EventEmitter } from 'protractor';
// import * as jwt from 'jsonwebtoken';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent  {
  // @Output() abc = new EventEmitter();

  isLoggedIn = false ;
  user = this.fb.group({ // for reactive groups, we are creating form builder groups which is where we create
    // one group and add multiple properties
    username: ['', Validators.required],
    password: ['', Validators.required]
  });
  constructor( private fb: FormBuilder, private loginService: AuthenticationService, private router: Router) { } // using router
  // to reroute valid logged in user to some other page
  helper = new JwtHelperService();

login() {
  this.loginService.login(this.user.value)
  .subscribe(res => {
  console.log('Res: ', res);
  console.log(this.helper.decodeToken(res.token).jti, 'this is the value of the userId');
  console.log(this.helper.decodeToken(res.token).sub, 'this is the value of the role');
     if ((this.helper.decodeToken(res.token).sub === 'admin' )) {
      this.router.navigate([`/profile`]);
      this.loginService.setCookie('token', res.token, 1);
      this.isLoggedIn = true;
      // this.loginService.setCookie('message', res.message, 1);
      // let token = this.loginService.getCookie('token');
    }
    if ((this.helper.decodeToken(res.token).sub === 'player' )) {
      this.router.navigate([`/game`]);
      this.loginService.setCookie('token', res.token, 1);
      this.isLoggedIn = true;
      // this.loginService.setCookie('message', res.message, 1);
      // let token = this.loginService.getCookie('token');
    }
    // else {
    //   console.log('you entered the wrong credentials');
    //   window.alert('Credentials you entered are incorrect');
    // }
    // if ((res.message === 'User successfully logged in' )) {
    //   this.router.navigate([`/profile`]);
    //   this.loginService.setCookie('token', res.token, 1);
    //   // this.loginService.setCookie('message', res.message, 1);
    //   // let token = this.loginService.getCookie('token');
    // } else {
    //   console.log('you entered the wrong credentials');
    //   window.alert('Credentials you entered are incorrect');
    // }
  });
}
logout() {
  this.loginService.deleteCookie('token');
  this.isLoggedIn = false;
  // this.sharedVariable.loggedIn.next(true);
  this.router.navigate(['/login']);
  // this.abc.emit(this.isLoggedIn);
}
}





