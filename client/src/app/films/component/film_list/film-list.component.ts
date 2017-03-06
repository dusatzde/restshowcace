import {Component, OnInit} from "@angular/core";
import {Film} from "../../model/film";
import {MOCK_FILMS} from "../../service/mock-films";
import {FilmService} from "../../service/film.service";
import {Observable} from "rxjs";

@Component({
  selector: 'film-list',
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.css'],
})
export class FilmListComponent implements OnInit {

  private loaded : boolean = false;
  private films: Film[];

  private newFilmFormVisibility : boolean = false;
  private newFilmFormSubmited : boolean = false;

  constructor(private filmService: FilmService) {

  }

  public ngOnInit(): void {
    this.filmService.getFilms().subscribe(films => {
      this.films = films;
      this.loaded = true;
    });
  }

  public onNewFilmNotify(film : Film):void {
    this.newFilmFormSubmited = true;
    this.newFilmFormVisibility = false;
    this.films.push(film);
  }

  public onNewFilmFormVisibilityNotify(visible : boolean):void {
    this.newFilmFormVisibility = visible;
  }

  public openNewFilmForm() : void{
    this.newFilmFormSubmited = false;
    this.newFilmFormVisibility = true;
  }

}
