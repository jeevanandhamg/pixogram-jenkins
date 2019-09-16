import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { UserHomePageComponent } from './user/user-home-page/user-home-page.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './header/header.component';
import { FollowersComponent } from './follow/followers/followers.component';
import { AllusersComponent } from './user/allusers/allusers.component';
import { FollowingComponent } from './follow/following/following.component';
import { UploadComponent } from './user/upload/upload.component';
import { UploadComponent } from './user/upload/upload.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    UserHomePageComponent,
    HeaderComponent,
    FollowersComponent,
    AllusersComponent,
    FollowingComponent,
    UploadComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path:'', component:LoginComponent,pathMatch:'full'},
      { path:'signup', component:SignupComponent},
      { path:'login', component:LoginComponent},
      { path:'userHomePage', component:UserHomePageComponent},
      { path:'followers', component:FollowersComponent},
      { path:'userList', component:AllusersComponent},
      { path:'following', component:FollowingComponent},
      { path: 'upload', component:UploadComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
