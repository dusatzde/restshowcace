import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './component/login.component';

export const routes: Routes = [
  {path: '', component: LoginComponent }
];

@NgModule({
  imports : [RouterModule.forChild(routes)],
  declarations : [],
  exports : [RouterModule]

})
export class LoginRoutingModule {

}
