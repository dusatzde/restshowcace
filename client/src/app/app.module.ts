import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {SharedModule} from "./shared/shared.module";
import {AppRountingModule} from "./app-routing.module";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";


@NgModule({
    declarations: [
        AppComponent,
    ],
    imports: [
        BrowserModule,
        SharedModule,
        AppRountingModule,
        NgbModule.forRoot()
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
