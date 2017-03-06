import {Component, Input, OnInit} from "@angular/core";
import {Film} from "../../model/film";
import {FilmService} from "../../service/film.service";
import {Router, ActivatedRoute, Params} from "@angular/router";


@Component({
  selector: 'film-detail',
  templateUrl: 'film-detail.component.html',
  styleUrls: ['film-detail.component.css']
})
export class FilmDetailComponent implements OnInit {

  film: Film;

  constructor(private filmService: FilmService,
              private route: ActivatedRoute,
              private router: Router,) {
  }

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.filmService.getFilm( +params['id']))
      .subscribe((film : Film) => this.film = film);
  }
}
