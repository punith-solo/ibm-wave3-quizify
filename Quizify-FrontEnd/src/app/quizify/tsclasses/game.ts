import { Category } from './category';
import { Question } from './question';
import { Topic } from './topic';
import { Genre } from './genre';
import { Tag } from './tag';
import { Admin } from './admin';

export class Game {
     id: number;
     name: string;
     category: Category;
     topic: Topic;
     playcount: number;
     numOfQuestion: number;
     questions: Array<Question>;
     admin: Admin;
     genre: Genre;
     level: string;
     liked: number;
     timeDuration: number;
}

