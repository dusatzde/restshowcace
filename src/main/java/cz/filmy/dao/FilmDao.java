package cz.filmy.dao;

import cz.filmy.bo.FilmBo;
import cz.filmy.bo.UserBo;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Zdenek on 09-Dec-16.
 */


public interface FilmDao extends CrudRepository<FilmBo, Long> {

        //vyhledat podle zanru
        List<FilmBo> findByGenre(String genre);
}
