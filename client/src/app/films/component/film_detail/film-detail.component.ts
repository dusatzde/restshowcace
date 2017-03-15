import { Component, OnInit } from '@angular/core';
import { Film } from '../../model/film';
import { FilmService } from '../../service/film.service';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
    selector: 'film-detail',
    templateUrl: 'film-detail.component.html',
    styleUrls: ['film-detail.component.css']
})
export class FilmDetailComponent implements OnInit {

    public film: Film = new Film();

    constructor(private filmService: FilmService,
                private route: ActivatedRoute) {
    }

    public ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.filmService.getFilm(+params['id']))
            .subscribe((film: Film) => this.film = film);
    }
}
