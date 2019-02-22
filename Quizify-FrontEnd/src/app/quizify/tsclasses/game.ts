import { Category } from './category';
import { Question } from './question';
import { Admin } from './admin';
import { Topic } from './topic';

export class Game {
     name: string;
     category: Category;
     topic: Topic;
     playcount: number;
     numOfQuestion: number;
     questions: Array<Question>;
     admin: Admin;
     level: string;
}
