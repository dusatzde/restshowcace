package cz.filmy.endpoint;

import cz.filmy.bo.UserBo;
import cz.filmy.exception.NotFoundException;
import cz.filmy.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

/**
 * Created by Zdenek on 05-Dec-16.
 */

@RestController
@RequestMapping("/api/v1/users")
public class UserEndpoint extends AbstractEndpoint {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<Collection<UserBo>> findAllUser(){
        Collection<UserBo> users =(Collection<UserBo>)service.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search")
    public ResponseEntity<UserBo> searchUser(@RequestParam("username") String userName) throws NotFoundException {
        UserBo user = service.findByUserName(userName);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserBo saveUser(@RequestBody UserBo user) {
        return service.save(user);
    }
}
