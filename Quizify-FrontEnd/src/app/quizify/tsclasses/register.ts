import { Topic } from './topic';
import { Genre } from './genre';

export class Register {

    name: string;
    password: string;
    confirmPassword: string;
    emailId: string;
    topics: Topic[];
    genres: Genre[];
    gender: string;
}

