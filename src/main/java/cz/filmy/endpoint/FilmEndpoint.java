package cz.filmy.endpoint;

import cz.filmy.dto.CommentDto;
import cz.filmy.dto.FilmDto;
import cz.filmy.exception.NotFoundException;
import cz.filmy.service.FilmService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Zdenek on 09-Dec-16.
 */

@RestController
@RequestMapping("/api/v1/films")
public class FilmEndpoint extends AbstractEndpoint{

    @Autowired
    private FilmService service;

    @GetMapping()
    public ResponseEntity<List<FilmDto>> findAllFilms(@RequestParam(value = "genre" , required = false) String genre){
        List<FilmDto> films = service.findAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/{film_id}")
    public FilmDto getFilm(@ApiParam(name = "filmId", value = "film ID ", defaultValue = "") @PathVariable("film_id") Long id) throws NotFoundException {
        return service.getFilm(id);
    }

    @PostMapping()
    public ResponseEntity<FilmDto> saveFilm(@RequestBody FilmDto film) {
        return new ResponseEntity<>(new FilmDto(service.saveFilm(film)), HttpStatus.CREATED);
    }

    @PutMapping("/{film_id}")
    public FilmDto updateFilm(@PathVariable("film_id") Long id, @RequestBody FilmDto filmDto) throws NotFoundException {
        filmDto.setFilmId(id);
        return service.updateFilm(filmDto);
    }

    @DeleteMapping("/{film_id}")
    public void deleteFilm(@PathVariable("film_id") Long id){
        service.deleteFilm(id);
    }

    @GetMapping("/{film_id}/comments")
    public ResponseEntity<List<CommentDto>> findCommentsOfFilm(@PathVariable("film_id") Long id) throws NotFoundException {
        return new ResponseEntity<>((List<CommentDto>)service.findCommentsOfFilm(id), HttpStatus.OK);
    }

    @PostMapping("/{film_id}/comments")
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    public CommentDto addComment(@PathVariable("film_id") Long filmId, @RequestBody CommentDto comment, Principal  user) throws NotFoundException {
        comment.setFilmId(filmId);
        return service.saveComment(comment, user);
    }

    @GetMapping("/{film_id}/comments/{comments_id}")
    public CommentDto getComment(@PathVariable("film_id") Long filmId, @PathVariable("comment_id") Long commentId) throws NotFoundException {
        return service.getComment(filmId, commentId);
    }


    @DeleteMapping("/{film_id}/comments/{comments_id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteComment(@PathVariable("film_id") Long filmId, @PathVariable("comment_id") Long commentId) throws NotFoundException {
         service.deleteComment(filmId, commentId);
    }
}
