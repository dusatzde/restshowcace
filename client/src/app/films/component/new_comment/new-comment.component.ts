import {Component, Input, Output, EventEmitter} from "@angular/core";
import {Film} from "../../model/film";
import {FilmService} from "../../service/film.service";
import {Comment} from "../../model/comment";

@Component({
  selector: 'film-new-comment',
  templateUrl: './new-comment.component.html',
  styleUrls: ['./new-comment.component.css'],
})
export class NewCommentComponent {

  @Input()
  private filmId: number;
  private comment : Comment = new Comment();

  @Output()
  newCommentNotify: EventEmitter<Comment> = new EventEmitter<Comment>();

  @Output()
  formVisibilityNotify: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor(private filmService:FilmService){

  }

  public onSubmit() {
    this.comment.filmId = this.filmId;

    // this.comment.userId =
    //   this.comment.userName =
    this.filmService.addComment(this.comment).subscribe(comment =>{


      debugger;
      this.newCommentNotify.emit(comment);
      this.filmService.addComment(comment)
    });
  }

  public hideForm(){
    this.formVisibilityNotify.emit(false);
  }


}
