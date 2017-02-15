package cz.filmy.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cz.filmy.bo.CommentBo;
import cz.filmy.bo.FilmBo;
import cz.filmy.bo.UserBo;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zdenek on 12-Dec-16.
 */
public class CommentDto {

    private Long commentId;
    private Date date;
    private String text;
    private Long filmId;
    private Long userId;

    public CommentDto(){

    }

    public CommentDto(CommentBo commentBo){
        commentId = commentBo.getCommentId();
        date = commentBo.getDate();
        text = commentBo.getText();
        filmId = (commentBo.getFilm() != null)?commentBo.getFilm().getFilmId(): -1;
        userId = (commentBo.getUser() != null)?commentBo.getUser().getUserId(): -1;
    }

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

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
