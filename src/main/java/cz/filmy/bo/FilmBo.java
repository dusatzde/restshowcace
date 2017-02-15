package cz.filmy.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Zdenek on 09-Dec-16.
 */

@Entity
@Table(name = "FILM_BO")
public class FilmBo implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long filmId;

    private Integer year;

    @NotEmpty
    private String name;

    //TODO: vytvorte novou tabulku DirectorBo(directorId, name) a predelejte na one-to-many
    @Column
    private String director;

    @NotEmpty
    private String genre;

    @JsonIgnore
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private Set<CommentBo> comments;

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

    public Set<CommentBo> getComments() {
        return comments;
    }

    public void setComments(Set<CommentBo> comments) {
        this.comments = comments;
    }
}
