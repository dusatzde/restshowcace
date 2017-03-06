import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {FilmListComponent} from "./films/component/film_list/film-list.component";
import {FilmDetailComponent} from "./films/component/film_detail/film-detail.component";

const routes: Routes = [
  {path: '', redirectTo: '/film', pathMatch: 'full'},
  {path: 'film', loadChildren: 'app/films/film.module#FilmModule'},
  {path: 'login', loadChildren: 'app/login/login.module#LoginModule'},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule
  ],
})
export class AppRountingModule {

}
