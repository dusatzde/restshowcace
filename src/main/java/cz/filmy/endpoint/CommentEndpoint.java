package cz.filmy.endpoint;

import cz.filmy.bo.CommentBo;
import cz.filmy.bo.FilmBo;
import cz.filmy.dto.CommentDto;
import cz.filmy.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
 * Created by Zdenek on 12-Dec-16.
 */

@RestController
@RequestMapping("/api/v1/comments")
public class CommentEndpoint {

    @Autowired
    private FilmService service;

    @GetMapping()
    public ResponseEntity<List<CommentDto>> findAllComments(){
        List<CommentDto> comments = (List<CommentDto>)service.findAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}

