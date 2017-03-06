import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {FilmListComponent} from "./component/film_list/film-list.component";
import {FilmDetailComponent} from "./component/film_detail/film-detail.component";

const routes: Routes = [
  {path: '', component: FilmListComponent},
  {path: ':id', component: FilmDetailComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FilmRoutingModule {
}
