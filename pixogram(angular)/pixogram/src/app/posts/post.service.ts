import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpEvent, HttpRequest, HttpClient } from '@angular/common/http';
import { User } from '../user/userModel';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

 upload(file: File,user,title:String,description:String): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();

    formdata.append('file', file);
    formdata.append('title',<string> title);
    formdata.append('description',<string> description);
    formdata.append('userid', user);

    const req = new HttpRequest('POST', 'http://localhost:9531/posts/upload', formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }

}
