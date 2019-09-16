import { Component, OnInit } from '@angular/core';
import { User } from '../user/userModel';
import { UserService } from '../user/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  uName:String;
  password:String;
  userWrongCredentials=true;

  constructor(private userService:UserService,private router:Router) { }

  ngOnInit() {
  }

  user:User=new User();

  private onSubmitUserLogin()
  {
    this.userService.userLoginCheck(this.uName,this.password)
    .subscribe((user:User) => 
    {
      this.user=user;
      if(this.user==null)
    {
      this.userWrongCredentials=false;
      console.log("wrong password");
      
    }
    else
    {
      console.log("correct password");
      this.userWrongCredentials=true;

      // this.setCurrentUser(user);
      localStorage.setItem('user', JSON.stringify(user));


      this.router.navigate(['/userHomePage']);
    }
    console.log(this.user);
   
    });
    
    
  }

  onSubmit()
  {
  this.onSubmitUserLogin();
  }
}
