import {NgModule} from "@angular/core";
import {FilmDetailComponent} from "./component/film_detail/film-detail.component";
import {FilmListComponent} from "./component/film_list/film-list.component";
import {FilmListItemComponent} from "./component/film_list_item/film-list-item.component";
import {FilmRoutingModule} from "./film-routing.module";
import {SharedModule} from "../shared/shared.module";
import {FilmService} from "./service/film.service";
import {CommentComponent} from "./component/comment/comment.component";
import {CommentListComponent} from "./component/comment-list/comment-list.component";
import {NewCommentComponent} from "./component/new_comment/new-comment.component";
import {NewFilmFormComponent} from "./component/new_film_form/new-film-form.component";

@NgModule({
  declarations: [
    FilmDetailComponent,
    FilmListComponent,
    FilmListItemComponent,
    CommentComponent,
    CommentListComponent,
    NewCommentComponent,
    NewFilmFormComponent,
  ],
  imports: [
    SharedModule,
    FilmRoutingModule,
  ],
  exports: [
    SharedModule,
    FilmListComponent,
  ],
  providers: [
    FilmService
  ]

})
export class FilmModule {

}
