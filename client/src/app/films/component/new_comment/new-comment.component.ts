import { Component, Input, Output, EventEmitter } from '@angular/core';
import { FilmService } from '../../service/film.service';
import { Comment } from '../../model/comment';

@Component({
  selector: 'film-new-comment',
  templateUrl: './new-comment.component.html',
  styleUrls: ['./new-comment.component.css'],
})
export class NewCommentComponent {

  @Input()
  public filmId: number;
  public comment: Comment = new Comment();

  @Output()
  public newCommentNotify: EventEmitter<Comment> = new EventEmitter<Comment>();

  @Output()
  public formVisibilityNotify: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor(private filmService: FilmService) {

  }

  public onSubmit() {
    this.comment.filmId = this.filmId;
    this.filmService.addComment(this.comment).subscribe( (comment) => {
      this.newCommentNotify.emit(comment);
      this.filmService.addComment(comment);
    });
  }

  public hideForm() {
    this.formVisibilityNotify.emit(false);
  }

}
