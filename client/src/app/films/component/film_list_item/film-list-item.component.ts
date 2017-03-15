import { Component, Input } from '@angular/core';
import { Film } from '../../model/film';

@Component({
    selector: 'film-list-item',
    templateUrl: 'film-list-item.component.html',
    styleUrls: ['film-list-item.component.css']
})
export class FilmListItemComponent {

    @Input()
    public film: Film;

}
