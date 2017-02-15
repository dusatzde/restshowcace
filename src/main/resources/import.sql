insert into USER_BO(user_Id, user_name, password, user_email) values (1000, 'Admin', 'password','admin@databaze.cz');
insert into USER_BO(user_Id, user_name, password, user_email) values (1001, 'zdedu', 'password', 'zdenek.dusatko@gmail.com');

insert into AUTHORITY_BO(authority_id, name) values (1,'ROLE_USER');
insert into AUTHORITY_BO(authority_id, name) values (2,'ROLE_ADMIN');

insert into USER_AUTHORITY(user_id, authority_id) values (1000, 1);
insert into USER_AUTHORITY(user_id, authority_id) values (1001, 1);
insert into USER_AUTHORITY(user_id, authority_id) values (1000, 2);

insert into FILM_BO(film_id, name, year, genre, director ) values (1000, 'Pupl Fiction','1994', 'crime, drama', 'Quentin Tarantino');
insert into FILM_BO(film_id, name, year, genre, director ) values (1001, 'Django Unchained','2012', 'drama, western', 'Quentin Tarantino');
insert into FILM_BO(film_id, name, year, genre, director ) values (1002, 'The Simpsons Movie','2007', 'comedy', 'David Silverman');

insert into COMMENT_BO(comment_id, date, text, film_id, user_id) values (1001, '2016-12-13 22:03:01', 'Very good movie. I love it.', 1000, 1001);