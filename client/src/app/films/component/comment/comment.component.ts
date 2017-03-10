import {Component, Input} from "@angular/core";
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
