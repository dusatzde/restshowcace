package cz.filmy.dao;

import cz.filmy.bo.CommentBo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Zdenek on 12-Dec-16.
 */
public interface CommentDao extends CrudRepository<CommentBo, Long> {

}
