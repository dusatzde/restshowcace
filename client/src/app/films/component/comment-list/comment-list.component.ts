import { Component, OnInit, Input } from '@angular/core';
import { FilmService } from '../../service/film.service';
import { Comment } from '../../model/comment';
import { AuthService } from '../../../shared/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'film-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']

})
export class CommentListComponent implements OnInit {

  @Input()
  public filmId: number;

  public comments: Comment[] = [];
  public newCommentFormVisibility: boolean = false;
  public newCommentFormSubmited: boolean = false;

  constructor(private filmService: FilmService, private authService: AuthService, private router: Router) {
  }

  public ngOnInit(): void {
    this.filmService.getFilmComments(this.filmId)
      .subscribe((comments: Comment[]) => this.comments = comments);
  }

  public onNewCommentNotify(comment: Comment): void {
    this.newCommentFormSubmited = true;
    this.newCommentFormVisibility = false;
    this.comments.push(comment);
  }

  public onNewCommentFormVisibilityNotify(visible: boolean): void {
    this.newCommentFormVisibility = visible;
  }

  public openNewCommentForm(): void {
    if (!this.authService.isAuthenticated()) {
      this.router.navigate(['login']);
    }
    this.newCommentFormSubmited = false;
    this.newCommentFormVisibility = true;
  }
}
