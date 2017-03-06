import {Component, OnInit, Input} from "@angular/core";
import {FilmService} from "../../service/film.service";
import {Comment} from "../../model/comment";
@Component({
  selector: 'film-comment',
  templateUrl: './comment.component.html',
  styleUrls:['./comment.component.css'],
})
export class CommentComponent {

  @Input()
  comment: Comment



}
