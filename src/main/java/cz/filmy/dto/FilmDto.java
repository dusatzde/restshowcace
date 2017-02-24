package cz.filmy.dto;

import cz.filmy.bo.FilmBo;

import java.io.Serializable;

/**
 * Created by Zdenek on 12-Dec-16.
 */
public class FilmDto  implements Serializable {

    private Long filmId;
    private Integer year;
    private String name;
    private String director;
    private String genre;

    public FilmDto() {
    }

    public FilmDto(FilmBo filmBo) {
        this.filmId = filmBo.getFilmId();
        this.year = filmBo.getYear();
        this.name = filmBo.getName();
        this.director = filmBo.getDirector();
        this.genre = filmBo.getGenre();
    }



    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
