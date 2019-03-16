import { Category } from './category';

import { Topic } from './topic';

import { Genre } from './genre';

export class Question {
    id: number;
    category: Category;
    topic: Topic;
    genre: Genre;
    level: string;
    type: string;
    statement: string;
    options: string[];
    correctAnswer: string;
    playerAnswer:string;
}
