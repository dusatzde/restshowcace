import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FilmService } from '../../service/film.service';
import { Genre } from '../../model/genre';
import { Film } from '../../model/film';

@Component({
  selector: 'film-new-form',
  templateUrl: './new-film-form.component.html',
  styleUrls: ['./new-film-form.component.css']
})
export class NewFilmFormComponent implements OnInit {

  public genres: Genre[] = [];
  public film: Film = new Film();

  @Output()
  public newFilmNotify: EventEmitter<Film> = new EventEmitter<Film>();

  @Output()
  public formVisibilityNotify: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor(private filmService: FilmService) {

  }

  public ngOnInit(): void {
    this.filmService.getGenres().subscribe((genres) => this.genres = genres);
  }

  public onSubmit() {
    this.filmService.create(this.film).subscribe((film) => {
      this.newFilmNotify.emit(film);
    });
  }

  public hideForm() {
      this.formVisibilityNotify.emit(false);
  }
}
