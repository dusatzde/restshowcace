package cz.filmy.endpoint;

import cz.filmy.dto.ApiResponse;
import cz.filmy.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Created by Zdenek on 06-Dec-16.
 * ERROR REST Status code hangling
 */


public class AbstractEndpoint {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ApiResponse exception(NotFoundException e) {
        return new ApiResponse(ApiResponse.ERROR, e.getMessage());
    }
}
