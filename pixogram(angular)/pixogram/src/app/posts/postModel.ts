import { User } from '../user/userModel';

export class Post
{
    id:number;
    userid:User;
    image:String;
    liked:number;
    unlike:number;
    comment:String;
    title:String;
    description:String;
}