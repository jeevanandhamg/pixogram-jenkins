import { Component, OnInit } from '@angular/core';
import { User } from '../userModel';
import { UserService } from '../user.service';
import { FollowService } from 'src/app/follow/follow.service';
import { Follow } from 'src/app/follow/followModel';

@Component({
  selector: 'app-allusers',
  templateUrl: './allusers.component.html',
  styleUrls: ['./allusers.component.css']
})
export class AllusersComponent implements OnInit {
  
  public n:boolean=false; 
  userList:User[];
  user:User=new User();
  follow:Follow=new Follow();
  following: Follow[];

  constructor(private userService:UserService, private followService:FollowService) { }

  ngOnInit() {
    this.user=JSON.parse(localStorage.getItem('user'));
    this.reloadData();
  }

  reloadData() 
  {
    this.userService.getAllUser(this.user)
    .subscribe(
      (response:User[])=>{
        this.checkUser(response)
      }
    );

    this.followService.getFollowingUsers(this.user)
    .subscribe(
      (response: Follow[]) => {
        this.checkFollowingUsers(response)
      }
    );


  }

 private checkFollowingUsers(followingusers:Follow[])
  {
  this.following=followingusers;
  
  if(this.following.length==0)
  {
    console.log("Null");
  }
 
  }

  private checkUser(response:User[])
  {
    this.userList=response;
    
    console.log(this.userList);
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
