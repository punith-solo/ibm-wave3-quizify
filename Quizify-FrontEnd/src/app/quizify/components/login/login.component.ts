import { AuthenticationService } from './../../services/authentication.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router' ;
import { first } from 'rxjs/operators' ;
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent  {
  isLoginError: boolean ;
  user = this.fb.group({ // for reactive groups, we are creating form builder groups which is where we create
    // one group and add multiple properties
  username: ['', Validators.required],
  password: ['', Validators.required]
});

constructor(private fb: FormBuilder, private loginService: AuthenticationService, private router: Router) { } // using router
// to reroute valid logged in user to some other page

login() {
  this.loginService.login(this.user.value)
  .subscribe(res => {
    console.log('Res: ', res);
    if (res.message === 'User successfully logged in') {
      this.router.navigate([`/profile`]);
      this.loginService.setCookie('token', res.token, 1);
      // this.loginService.setCookie('message', res.message, 1);
      // let token = this.loginService.getCookie('token');
    } else {
      console.log('you entered the wrong credentials');
      window.alert('Credentials you entered are incorrect');
    }
  });
}

}





