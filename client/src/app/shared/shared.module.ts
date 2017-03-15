import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { JsonpModule, HttpModule } from '@angular/http';

import { AuthService } from './auth/auth.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpModule,
    JsonpModule,
  ],

  exports: [
    CommonModule,
    FormsModule,
  ],

  providers : [
    AuthService,
  ]
})
export class SharedModule {

}
