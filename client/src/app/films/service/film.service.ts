import {Injectable} from "@angular/core";
import {Film} from "../model/film";
import {Observable} from "rxjs";
import {MOCK_FILMS, MOCK_COMMENTS} from "./mock-films";
import {Comment} from "../model/comment";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {API_FILMS_ENDPOINT} from "../../shared/api-util";
import {AbstractHttpService} from "../../shared/abstract-http.service";
import {Genre} from "../model/genre";
import {AuthService} from "../../shared/auth/auth.service";


@Injectable()
export class FilmService extends AbstractHttpService {

  constructor(private http: Http, private authService : AuthService) {
    super();
  }

  public getFilms(): Observable<Film[]> {
    return this.http.get(API_FILMS_ENDPOINT)
      .map(this.extractData)
      .catch(this.handleError);
  }

  public getFilm(id: number): Observable<Film> {
    return this.http.get(API_FILMS_ENDPOINT + id)
      .map(this.extractData)
      .catch(this.handleError);
  }

  public getFilmComments(filmId: number): Observable<Comment[]> {
    return this.http.get(API_FILMS_ENDPOINT + filmId + '/comments')
      .map(this.extractData)
      .catch(this.handleError);
  }

  public create(film: Film) : Observable<Film>{

    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({ headers: headers });

    return this.http.post(API_FILMS_ENDPOINT, film, options)
      .map(this.extractData)
      .catch(this.handleError);
  }

  public addComment(comment : Comment) : Observable<Comment>{
    let headers = new Headers({'Content-Type': 'application/json'});
    headers.append('Authorization', 'Basic bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0');
    let options = new RequestOptions({ headers: headers });
    let token = this.authService.getToken();
    return this.http.post(API_FILMS_ENDPOINT + comment.filmId + '/comments/?access_token=' + token, comment, options)
      .map(this.extractData)
      .catch(this.handleError);
  }

  public getGenres(): Observable<Genre[]> {
    return Observable.of([{name: 'Action'}, {name: 'Comedy'}, {name: 'Crime'}, {name: 'Drama'}, {name: 'Fantasy'}, {name: 'Horror'}, {name: 'Romance'}, {name: 'Thriller'}, {name: 'Western'}]);
  }


  public getFilmsMock(): Observable<Film[]> {
    return Observable.of(MOCK_FILMS);
  }

  public getFilmMock(id: number): Observable<Film> {
    return this.getFilms()
      .map(films => films.filter(film => film.filmId === id)[0]);
  }

  public getFilmCommentsMock(filmId: number): Observable<Comment[]> {
    return Observable.of(MOCK_COMMENTS)
      .map(comments => comments.filter(comment => comment.filmId === filmId));
  }

}
