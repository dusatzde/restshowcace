package cz.filmy.service;

import cz.filmy.bo.CommentBo;
import cz.filmy.bo.FilmBo;
import cz.filmy.bo.UserBo;
import cz.filmy.dto.ApiResponse;
import cz.filmy.dto.CommentDto;
import cz.filmy.dto.FilmDto;
import cz.filmy.exception.NotFoundException;
import org.springframework.security.oauth2.client.resource.UserRedirectRequiredException;
import org.springframework.stereotype.Service;
import cz.filmy.dao.*;

import javax.transaction.Transactional;
import javax.xml.stream.events.Comment;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Zdenek on 09-Dec-16.
 */

@Service
@Transactional
public class FilmService {

    private final FilmDao filmDao;
    private final CommentDao commentDao;
    private final UserDao userDao;

    public FilmService(FilmDao filmDao, CommentDao commentDao, UserDao userDao) {
        this.filmDao = filmDao;
        this.commentDao = commentDao;
        this.userDao = userDao;
    }

    public FilmDto getFilm(Long id) throws NotFoundException {
        FilmBo film = filmDao.findOne(id);
        if (film == null) {
            throw new NotFoundException(ApiResponse.ERROR, "film " + id + " not found");
        }
        return new FilmDto(film);
    }

    public FilmBo saveFilm(FilmDto filmDto) {
        FilmBo filmBo = convertFilmToBo(new FilmBo(), filmDto);
        return this.filmDao.save(filmBo);
    }

    public void deleteFilm(Long id) {
        this.filmDao.delete(id);
    }

    public FilmDto updateFilm(FilmDto film) throws NotFoundException {
        FilmBo filmBo = filmDao.findOne(film.getFilmId());
        if (filmBo == null) {
            throw new NotFoundException(ApiResponse.ERROR, "film " + film.getFilmId() + " not found");
        }
        filmBo = convertFilmToBo(filmBo, film);
        return new FilmDto(filmDao.save(filmBo));
    }

    public List<FilmDto> findAllFilms() {
        Stream<FilmBo> filmBoStream = StreamSupport.stream(filmDao.findAll().spliterator(), false);
        List<FilmDto> filmDTOs = filmBoStream.map(FilmDto::new).collect(Collectors.toList());
        return filmDTOs;
    }

    public Iterable<CommentDto> findAllComments() {
        Stream<CommentBo> commentBoStream = StreamSupport.stream(commentDao.findAll().spliterator(), false);
        List<CommentDto> commentDTOs = commentBoStream.map(CommentDto::new).collect(Collectors.toList());
        return commentDTOs;
    }

    public Iterable<CommentDto> findCommentsOfFilm(Long filmId) throws NotFoundException {
        FilmBo film = findOneFilm(filmId);
        Stream<CommentBo> commentBoStream = StreamSupport.stream(film.getComments().spliterator(), false);
        List<CommentDto> commentDTOs = commentBoStream.map(CommentDto::new).collect(Collectors.toList());
        return commentDTOs;

    }

    public CommentDto saveComment(CommentDto commentDto, Principal user) throws NotFoundException {

        UserBo userBo = findOneUserByName(user.getName());
        FilmBo filmBo = findOneFilm(commentDto.getFilmId());
        CommentBo commentBo = new CommentBo();
        commentBo.setUser(userBo);
        commentBo.setFilm(filmBo);

        commentBo = convertCommentToBo(commentBo, commentDto);
        return new CommentDto(commentDao.save(commentBo));
    }

    public CommentDto getComment(Long filmId, Long id) throws NotFoundException {
        CommentBo commentBo = findOneComment(id);
        if(commentBo.getFilm().getFilmId() != filmId){
            throw new NotFoundException(ApiResponse.ERROR, "film " + filmId + " does not have comment with id " + id);
        }
        return new CommentDto(commentBo);
    }

    public void deleteComment(Long filmId, Long id) throws NotFoundException {
        CommentBo commentBo= findOneComment(id);
        if(commentBo == null || filmId != commentBo.getFilm().getFilmId()){
            throw new NotFoundException(ApiResponse.ERROR, "film " + filmId + " does not have comment with id " + id);
        }
        this.commentDao.delete(commentBo);
    }

    private FilmBo convertFilmToBo(FilmBo filmBo, FilmDto filmDto) {
        filmBo.setDirector(filmDto.getDirector());
        filmBo.setGenre(filmDto.getGenre());
        filmBo.setName(filmDto.getName());
        filmBo.setYear(filmDto.getYear());
        return filmBo;
    }

    private CommentBo convertCommentToBo(CommentBo commentBo, CommentDto CommentDto) {
        commentBo.setDate(CommentDto.getDate());
        commentBo.setText(CommentDto.getText());
        return commentBo;
    }

    private FilmBo findOneFilm(Long id) throws NotFoundException {
        FilmBo film = filmDao.findOne(id);
        if (film == null) {
            throw new NotFoundException(ApiResponse.ERROR, "film " + film.getFilmId() + " not found");
        }
        return film;
    }


    private UserBo findOneUserByName(String username) throws NotFoundException{
        UserBo user = userDao.findByUserName(username);
        if (user == null) {
            throw new NotFoundException(ApiResponse.ERROR, "user " + username + " not found");
        }
        return user;
    }


    private CommentBo findOneComment(Long id) throws NotFoundException{
        CommentBo comment = commentDao.findOne(id);
        if (comment == null) {
            throw new NotFoundException(ApiResponse.ERROR, "comment " + id + " not found");
        }
        return comment;
    }
}
