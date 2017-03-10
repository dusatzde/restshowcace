import {Component, OnInit, EventEmitter, Output, Input} from "@angular/core";
import {FilmService} from "../../service/film.service";
import {Genre} from "../../model/genre";
import {Film} from "../../model/film";

@Component({
  selector: 'film-new-form',
  templateUrl: './new-film-form.component.html',
  styleUrls: ['./new-film-form.component.css']
})
export class NewFilmFormComponent implements OnInit{

  private genres : Genre[] = [];
  private film: Film = new Film();

  @Output()
  newFilmNotify: EventEmitter<Film> = new EventEmitter<Film>();

  @Output()
  formVisibilityNotify: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor(private filmService : FilmService){

  }

  ngOnInit(): void {
    this.filmService.getGenres().subscribe(genres => this.genres = genres);
  }

  public onSubmit() {

    this.filmService.create(this.film).subscribe(film =>{
      this.newFilmNotify.emit(film);
    });
  }

  public hideForm(){
      this.formVisibilityNotify.emit(false);
  }
}
