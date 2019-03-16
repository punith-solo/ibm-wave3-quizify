import { Category } from './category';
import { Topic } from './topic';
import { Genre } from './genre';

export class QuestionDetails {
category: Category;
topic: Topic;
genre: Genre;
level: string;
type: string;
}
