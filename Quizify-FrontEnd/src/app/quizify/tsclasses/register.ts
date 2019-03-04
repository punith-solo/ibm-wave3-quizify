import { Genre } from './Genre';
import { Topic } from './topic';

export class Register {

    name: string;
    password: string;
    // confirmPassword: string;
    emailId: string;
    topics: Topic[];
    genres: Genre[];
    gender: string;
}

