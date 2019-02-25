import { Category } from './category';
import { Topic } from './topic';
import { Admin } from './admin';

export class Question {
    id: string;
    category: Category;
    topic: Topic;
    level: string;
    type: string;
    statement: string;
    options: string[];
    answer: string;
    admin: Admin;
}
