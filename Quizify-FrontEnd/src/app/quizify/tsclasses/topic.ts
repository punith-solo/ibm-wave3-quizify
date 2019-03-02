import { Admin } from './admin';
export class Topic {

     id: number;
    name: string;
    imageUrl: string;
    timeStamp: string;
    subTopics: Topic[];
    admin: Admin;
}
