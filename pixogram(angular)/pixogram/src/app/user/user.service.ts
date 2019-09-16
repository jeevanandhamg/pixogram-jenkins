import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './UserModel';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:9531/user';

  constructor(private http: HttpClient) { }

  getAllUser(user:User): Observable<any>
  {
    return this.http.post(`${this.baseUrl}/users`,user);
  }

  userLoginCheck(userUName:String,userPassword:String): Observable<any>
  {
    return this.http.get(`${this.baseUrl}/loginUser/${userUName}/${userPassword}`);
  }

  userSignup(user:User): Observable<any>
 {
   return  this.http.post(`${this.baseUrl}` + `/signupUser`, user);
 }

 blockUser(user:User): Observable<any>
 {

 return  this.http.post(`${this.baseUrl}` + `/blockuser`, user); 
 }
}
