package cz.filmy.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zdenek on 09-Dec-16.
 */

@Entity
@Table(name = "COMMENT_BO")
public class CommentBo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long commentId;

    //H2 format: yyyy-MM-dd hh:mm:ss
    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @NotEmpty
    private String text;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FILM_ID")
    private FilmBo film;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private UserBo user;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public FilmBo getFilm() {
        return film;
    }

    public void setFilm(FilmBo film) {
        this.film = film;
    }

    public UserBo getUser() {
        return user;
    }

    public void setUser(UserBo user) {
        this.user = user;
    }
}
