import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/posts/post.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Post } from 'src/app/posts/postModel';
import { UseExistingWebDriver } from 'protractor/built/driverProviders';
import { User } from '../userModel';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {

  
  selectedFiles: FileList;
  currentFileUpload: File;
  post:Post=new Post();

  user:User=new User();

  constructor(private postService:PostService) { }

  ngOnInit() {
    this.user=JSON.parse(localStorage.getItem('user'));
  }

  
  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() { 
    
    this.post.userid=this.user;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.postService.upload(this.currentFileUpload,this.post.userid,this.post.title,this.post.description).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
       console.log("failed");
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    });

    this.selectedFiles = undefined;
  }

}
