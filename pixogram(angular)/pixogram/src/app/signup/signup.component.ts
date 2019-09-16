import { Component, OnInit } from '@angular/core';
import { User } from '../user/userModel';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

 
  user:User=new User();

  constructor(private userService:UserService) { }

  ngOnInit() {
  }

  private onSubmitUserSignup()
  {
    this.userService.userSignup(this.user)
    .subscribe((user:User) => {
      this.user=user
      console.log(this.user);
    });
    this.user= new User();
  }

  onSubmit(){

    this.onSubmitUserSignup();
  }
}
