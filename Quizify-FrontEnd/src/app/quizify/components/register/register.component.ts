// import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { RegisterService } from '../../services/register.service';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Level } from '../game/game.component';
import { Register } from '../../tsclasses/register';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  formGroup2: FormGroup;
  // tslint:disable-next-line:no-inferrable-types
  isOptional: boolean = false;
  formGroup1: FormGroup;
  formGroup3: FormGroup;
  userForm: any;
  value1: String;
  disabled = false;
  ShowFilter = false;
  limitSelection = false;
  generes: any = [];
  selectedItems: any = [];
  dropdownSettings: any = {};


  @Input()
  register: Register;
  private userName: string;
  private password: string;
  private confirmPassword: string;
  private emailId: string;
  private interests: string;
  private gender: string;
  private levels: Level[];

  @ViewChild('myStep') myStep;
  myForm: FormGroup;

  // tslint:disable-next-line:max-line-length
  constructor(private _formBuilder: FormBuilder, private regserv: RegisterService,  private http: HttpClient) {
    this. levels = [
      {value: 'movies', viewValue: 'Movies'},
      {value: 'tvshows', viewValue: 'TvShows'},
    ];
 }
 submit(event: any) {
  this.register = new Register();
  this.register.userName = this.userName;
  this.register.password = this.password;
  this.register.interests = this.interests;
  this.register.gender = this.gender;
  this.register.emailId = this.emailId;
  this.register.confirmPassword = this.confirmPassword;
   console.log(this.register);
  this.value1 = event.target.value;
  this.regserv.addUser(this.register).subscribe((data: any) => {
   console.log('user data', data);
  });

}
  ngOnInit() {
    this.formGroup1 = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.formGroup2 = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
    this.formGroup3 = this._formBuilder.group({
      thirdCtrl: ['', Validators.required]
    });
  }
}
  //   addUser(searchText: string) {
  //      console.log('hi');
  //    this.http.get('https://localhost:8899/api/v1/user').subscribe(resp => {
  //        console.log(resp);
  //    this.response = resp;
  //        });
  //    return this.response;
  //    }

