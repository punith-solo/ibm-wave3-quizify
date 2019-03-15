import { Component, OnInit, ViewChild } from '@angular/core';
import { JsonService } from '../../services/json.service';
import { FormBuilder } from '@angular/forms';
import { MatSnackBar, MatTableDataSource, MatPaginator } from '@angular/material';
import { Category } from '../../tsclasses/category';
import { Topic } from '../../tsclasses/topic';
import { Genre } from '../../tsclasses/genre';
import { Question } from '../../tsclasses/question';
import { AdminQuestionService } from '../../services/admin-question.service';

export interface Levels {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {
  
  private category: Category;
  private categories: Category[];
  private topic: Topic;
  private topics: Topic[];
  private genre: Genre;
  private genres: Genre[];
  private levels: Levels[];
  private question: Question;
  private questions: Question[];

  private selectedCategory: Category;
  private selectedTopic: Topic;
  private selectedGenre: Genre;

  private tfStatement: string;
  private tfselectedOption: string;
  private tfselectedLevel: string;

  private mcqStatement: string;
  private mcqOption1: string;
  private mcqOption2: string;
  private mcqOption3: string;
  private mcqOption4: string;
  private mcqSelectedOption: string;
  private mcqSelectedLevel: string;


  statusCode: any;

  private ELEMENT_DATA: PeriodicElement[];
  displayedColumns: string[] = ['ID', 'Statement', 'Category', 'Topic', 'Category'];
  dataSource = new MatTableDataSource<PeriodicElement>(this.ELEMENT_DATA);
  @ViewChild(MatPaginator) paginator: MatPaginator;


  constructor(
    private jsonServer: JsonService,
    private questionService: AdminQuestionService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.questionService.getAllQuestions().subscribe((res: any) => {
      this.questions = res.body;
      
    });

    this.jsonServer.getCategoryFromJsonServer().subscribe((res: any[]) => {
      this.categories = res;
    });

    this.jsonServer.getTopicFromJsonServer().subscribe((res: any[]) => {
      this.topics = res;
    });

    this.jsonServer.getGenreFromJsonServer().subscribe((res: any[]) => {
      this.genres = res;
    });

    this.levels = [
      {value: 'easy', viewValue: 'Easy'},
      {value: 'medium', viewValue: 'Medium'},
      {value: 'hard', viewValue: 'Hard'}
    ];

    this.selectedCategory = new Category();
    this.selectedTopic = new Topic();
    this.selectedGenre = new Genre();

    this.tfselectedOption = '';
    this.tfStatement = '';
    this.tfselectedLevel = '';

    this.mcqStatement = '';
    this.mcqOption1 = '';
    this.mcqOption2 = '';
    this.mcqOption3 = '';
    this.mcqOption4 = '';
    this.mcqSelectedOption = '';
    this.mcqSelectedLevel = '';
  }

  saveMcqQuestion() {
    if ( 
      this.selectedCategory.name !== undefined &&
      this.selectedTopic.name !== undefined &&
      this.selectedGenre.name !== undefined &&
      this.mcqStatement !== '' &&
      this.mcqOption1 !== '' &&
      this.mcqOption2 !== '' &&
      this.mcqOption3 !== '' &&
      this.mcqOption4 !== '' &&
      this.mcqSelectedOption !== '' &&
      this.mcqSelectedLevel !== ''
      )
      {
        this.question = new Question();
        this.question.id = 0;
        this.question.category = this.selectedCategory;
        this.question.topic = this.selectedTopic;
        this.question.genre = this.selectedGenre;
        this.question.tag = null;
        this.question.level = this.mcqSelectedLevel;
        this.question.type = 'mcq';
        this.question.statement = this.mcqStatement;
        this.question.options = [this.mcqOption1, this.mcqOption2, this.mcqOption3, this.mcqOption3];
        this.question.correctAnswer = this.mcqSelectedOption;
        this.question.playerAnswer = null;

        this.questionService.saveQuestion(this.question).subscribe(
          (response: any) => {
            this.statusCode = response.status;
            if (this.statusCode === 200) {
              console.log('Success', this.statusCode);
              this.snackBar.open('Question Successfully Saved !!!', '', {
                duration: 1500
              });
            }
          },
          err => {
            const errorStatus = err;
            this.statusCode = parseInt(errorStatus, 10);
            if (this.statusCode === 409) {
              this.snackBar.open('Question Already Exists', '', {
                duration: 1500
              });
              this.statusCode = 0;
            }
        });
        
      }
      else if (this.selectedCategory.name === undefined)
      {
        this.snackBar.open('Please Select A Category !', '', {
          duration: 1500
        });

      }
      else if (this.selectedTopic.name === undefined)
      {
        this.snackBar.open('Please Select A Topic !', '', {
          duration: 1500
        });

      }
      else if (this.selectedGenre.name === undefined)
      {
        this.snackBar.open('Please Select A Genre !', '', {
          duration: 1500
        });
      }
      else if ( 
        this.mcqStatement === '' ||
        this.mcqOption1 === '' ||
        this.mcqOption2 === '' ||
        this.mcqOption3 === '' ||
        this.mcqOption4 === '' ||
        this.mcqSelectedOption === '' ||
        this.mcqSelectedLevel === ''
        )
        {
          this.snackBar.open('Please Give Question Details !', '', {
            duration: 1500
          });
        }
  }

  saveTFQuestion() {
    if ( 
      this.selectedCategory.name !== undefined &&
      this.selectedTopic.name !== undefined &&
      this.selectedGenre.name !== undefined &&
      this.tfStatement !== '' &&
      this.tfselectedOption !== '' &&
      this.tfselectedLevel !== ''
      )
      {
        this.question = new Question();
        this.question.id = 0;
        this.question.category = this.selectedCategory;
        this.question.topic = this.selectedTopic;
        this.question.genre = this.selectedGenre;
        this.question.tag = null;
        this.question.level = this.tfselectedLevel;
        this.question.type = 't/f';
        this.question.statement = this.tfStatement;
        this.question.options = ['true', 'false'];
        this.question.correctAnswer = this.tfselectedOption;
        this.question.playerAnswer = null;

        this.questionService.saveQuestion(this.question).subscribe(
          (response: any) => {
            this.statusCode = response.status;
            if (this.statusCode === 200) {
              console.log('Success', this.statusCode);
              this.snackBar.open('Question Successfully Saved !!!', '', {
                duration: 1500
              });
            }
          },
          err => {
            const errorStatus = err;
            this.statusCode = parseInt(errorStatus, 10);
            if (this.statusCode === 409) {
              this.snackBar.open('Question Already Exists', '', {
                duration: 1500
              });
              this.statusCode = 0;
            }
        });
        
      }
      else if (this.selectedCategory.name === undefined)
      {
        this.snackBar.open('Please Select A Category !', '', {
          duration: 1500
        });

      }
      else if (this.selectedTopic.name === undefined)
      {
        this.snackBar.open('Please Select A Topic !', '', {
          duration: 1500
        });

      }
      else if (this.selectedGenre.name === undefined)
      {
        this.snackBar.open('Please Select A Genre !', '', {
          duration: 1500
        });
      }
      else if ( 
        this.tfStatement === '' ||
        this.tfselectedOption === '' ||
        this.tfselectedLevel === ''
        )
        {
          this.snackBar.open('Please Give Question Details !', '', {
            duration: 1500
          });
        }
  }

  

}

export interface PeriodicElement {
  ID: number;
  Statement: string;
  Category: string;
  Topic: string;
  Genre: string;
  Level: string;
  Type: string;
}

// const ELEMENT_DATA: PeriodicElement[] = [
//   {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
//   {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
//   {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
//   {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
//   {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
//   {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
//   {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
//   {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
//   {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
//   {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
//   {position: 11, name: 'Sodium', weight: 22.9897, symbol: 'Na'},
//   {position: 12, name: 'Magnesium', weight: 24.305, symbol: 'Mg'},
//   {position: 13, name: 'Aluminum', weight: 26.9815, symbol: 'Al'},
//   {position: 14, name: 'Silicon', weight: 28.0855, symbol: 'Si'},
//   {position: 15, name: 'Phosphorus', weight: 30.9738, symbol: 'P'},
//   {position: 16, name: 'Sulfur', weight: 32.065, symbol: 'S'},
//   {position: 17, name: 'Chlorine', weight: 35.453, symbol: 'Cl'},
//   {position: 18, name: 'Argon', weight: 39.948, symbol: 'Ar'},
//   {position: 19, name: 'Potassium', weight: 39.0983, symbol: 'K'},
//   {position: 20, name: 'Calcium', weight: 40.078, symbol: 'Ca'},
// ];