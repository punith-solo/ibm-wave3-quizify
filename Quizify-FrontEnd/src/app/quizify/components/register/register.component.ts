import { Topic } from './../../tsclasses/topic';
import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { RegisterService } from '../../services/register.service';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Register } from '../../tsclasses/register';
import { Genre } from '../../tsclasses/Genre';
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
  formGroup4: FormGroup;
  userForm: any;
  value1: String;
  disabled = false;
  ShowFilter = false;
  limitSelection = false;
  topic: any = [];
  genre: any = [];
  selectedItems: any = [];
  dropdownSettings: any = {};

  @Input()
  register: Register;
  private name: string;
  private password: string;
  private confirmPassword: string;
  private emailId: string;
  private topics: Topic[];
  private genres: Genre[];
  private gender: string;

  private topicList: Topic[];
  private genreList: any[];

  @ViewChild('myStep') myStep;
  myForm: FormGroup;

  // tslint:disable-next-line:max-line-length
  constructor(private _formBuilder: FormBuilder, private regserv: RegisterService,  private http: HttpClient) {
 }
 submit(event: any) {
  this.register = new Register();
  this.register.name = this.name;
  this.register.password = this.password;
  this.register.topics = this.topics;
  this.register.genres = this.genres;
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
    this.formGroup4 = this._formBuilder.group({
      fourCtrl: ['', Validators.required]
    });

    this.regserv.getTopic().subscribe((res: any) => {
      this.topicList = res;
    });

    this.regserv.getGenre().subscribe((res: any) => {
      // this.genreList = res;
      console.log(res);
      // console.log(this.genreList);
    });
  }

}
