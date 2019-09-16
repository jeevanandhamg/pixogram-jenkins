import { Component, OnInit } from '@angular/core';
import { FollowService } from '../follow.service';
import { User } from 'src/app/user/userModel';
import { Follow } from '../followModel';

@Component({
  selector: 'app-following',
  templateUrl: './following.component.html',
  styleUrls: ['./following.component.css']
})
export class FollowingComponent implements OnInit {

  constructor(private followService:FollowService) { }

  follow:Follow=new Follow();
  user:User=new User();
  following:Follow[];

  ngOnInit() {
    this.user=JSON.parse(localStorage.getItem('user'));
   
    this.reloadData();
  }

reloadData()
{
  console.log("hitting");
  console.log(this.user);
  this.followService.getFollowingUsers(this.user)
    .subscribe(
      (response: Follow[]) => {
        this.checkFollowingUsers(response)
      }
    );

   
}
checkFollowingUsers(followingusers:Follow[])
{
  this.following=followingusers;
  if(this.following.length==0)
  {
    console.log("Null");
  }
 
}
 unFollow(follow:Follow)
 {
   this.followService.unFollow(follow)
   .subscribe(
    (response: Follow) => {
      console.log(response);
    }
  );
  this.reloadData();
 }


}
