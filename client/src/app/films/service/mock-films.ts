import {Film} from "../model/film";
import {Comment} from "../model/comment";


export  const MOCK_FILMS: Film[] = [
    { filmId: 1001, name: 'Pulp Fiction', year: 1994, director: 'Quentin Tarantino', genre: 'crime, drama'},
    { filmId: 1002, name: 'Django Unchained', year: 2007, genre: 'western, drama', director: 'Quentin Tarantino' },
    { filmId: 1003, name: 'The Simpsons Movie', year: 1994, genre: 'comedy', director: 'David Silverman'}
];

export  const MOCK_COMMENTS: Comment[] = [
  { commentId: 1001, date: '1.1.2017', text: 'Nice film', filmId: 1001, userId: 1001, userName: 'Zdenek Dusatko'},
  { commentId: 1001, date: '1.1.2017', text: 'Very funny', filmId: 1001, userId: 1001, userName: 'Yeah Go'},
];
