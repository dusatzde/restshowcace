package cz.filmy.dao;

import cz.filmy.bo.UserBo;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Zdenek on 05-Dec-16.
 */


public interface UserDao extends PagingAndSortingRepository<UserBo, Long> {
    UserBo findByUserName(String userName);
}
