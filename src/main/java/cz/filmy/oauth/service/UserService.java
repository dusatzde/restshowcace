package cz.filmy.oauth.service;

import cz.filmy.bo.UserBo;
import cz.filmy.dao.UserDao;
import cz.filmy.dto.ApiResponse;
import cz.filmy.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by Zdenek on 05-Dec-16.
 */

@Service
@Transactional
public class UserService implements UserDetailsService{

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    public UserBo findByUserName(String userName) throws NotFoundException{
        UserBo user = userDao.findByUserName(userName);
        if(user == null){
            throw new NotFoundException(ApiResponse.ERROR, "User " + userName + " not found");
        }
        return user;
    }

    @PreAuthorize("#oauth2.hasScope('write')")
    public UserBo save(UserBo user) {
        return userDao.save(user);
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    public Iterable<UserBo> findAll() {
        return userDao.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBo user = userDao.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }
        return new UserRepositoryUserDetails(user);
    }

    private final static class UserRepositoryUserDetails  implements UserDetails {

        private static final long serialVersionUID = 1L;

        private final UserBo user;

        private UserRepositoryUserDetails(UserBo user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return user.getAuthorities();
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUserName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

    }
}
