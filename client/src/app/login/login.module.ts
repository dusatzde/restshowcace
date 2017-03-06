import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {LoginComponent} from "./component/login.component";
import {LoginRoutingModule} from "./login-routing.module";

@NgModule({
  imports:[
    SharedModule,
    LoginRoutingModule,
  ],
  exports : [
    SharedModule
  ],
  declarations : [
    LoginComponent,
  ],
})
export class LoginModule{

}
