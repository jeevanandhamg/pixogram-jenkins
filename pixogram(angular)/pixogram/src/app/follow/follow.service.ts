import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user/userModel';
import { Observable } from 'rxjs';
import { Follow } from './followModel';

@Injectable({
  providedIn: 'root'
})
export class FollowService {

  private baseUrl = 'http://localhost:9531/follow';

  constructor(private http: HttpClient) { }

  getFollowingUsers(user:User): Observable<any>
  {
    return  this.http.post(`${this.baseUrl}` + `/following`, user);
  }

  getFollowers(user:User): Observable<any>
  {
    return  this.http.post(`${this.baseUrl}` + `/followers`, user);
  }

  updateFollow(follow:Follow): Observable<any>
  {
    return  this.http.post(`${this.baseUrl}` + `/update`, follow);
  }

  unFollow(follow:Follow):Observable<any>
  {
    return this.http.post(`${this.baseUrl}` + `/unfollow`, follow);
  }
}
