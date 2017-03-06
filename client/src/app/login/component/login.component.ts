import {Component} from "@angular/core";
import {AuthService} from "../../shared/auth/auth.service";
import {Router} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector : 'login',
  templateUrl : 'login.component.html'
})
export class LoginComponent{

  private username : string;
  private password : string;

  constructor(private authService : AuthService,  private location: Location){

  }

  public onSubmit() : void {
      this.authService.authenticate(this.username, this.password);
  }

  public login(event, username, password) {

    event.preventDefault();

    this.authService.authenticate(username, password)
      .subscribe(
        response => {
          this.location.back();
        },
        error => {
          alert(error);
        }
      );
  }

}
