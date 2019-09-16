import { Component, OnInit } from '@angular/core';
import { FollowService } from '../follow.service';
import { User } from 'src/app/user/userModel';
import { Follow } from '../followModel';

@Component({
  selector: 'app-followers',
  templateUrl: './followers.component.html',
  styleUrls: ['./followers.component.css']
})
export class FollowersComponent implements OnInit {

  constructor(private followService:FollowService) { }

  user:User=new User();
  public n:boolean=false; 
  
  follow:Follow=new Follow();
  followers:Follow[];
  following:Follow[];

  ngOnInit() {
    this.user=JSON.parse(localStorage.getItem('user'));
   
    this.reloadData();
  }

reloadData()
{
 this.n=false;
  this.followService.getFollowers(this.user)
    .subscribe(
      (response: Follow[]) => {
        this.checkFollowerUsers(response)
      }
    );

    this.followService.getFollowingUsers(this.user)
    .subscribe(
      (response: Follow[]) => {
        this.checkFollowingUsers(response)
      }
    );

   
}
checkFollowerUsers(followers:Follow[])
{
  this.followers=followers;
  // this.n=this.followers.length-1;
  // console.log(this.n);
  if(this.followers.length==0)
  {
    console.log("Null");
  }
 
}
checkFollowingUsers(followingusers:Follow[])
{
  this.following=followingusers;
  
  if(this.following.length==0)
  {
    console.log("Null");
  }
 
}

followUser(u:User)
{
  this.follow.userid=this.user;
  this.follow.followid=u;
  this.followService.updateFollow(this.follow)
  .subscribe(
    (response:Follow)=>{
     console.log(response);
    }
  );
  this.reloadData();
}

passIndex()
{
 
  this.n=true;
  console.log(this.n);
}

summa()
{
  this.n=false;
  console.log(this.n);
}
 
}
