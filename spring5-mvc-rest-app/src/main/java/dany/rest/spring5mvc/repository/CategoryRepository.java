package dany.rest.spring5mvc.repository;

import dany.rest.spring5mvc.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bautisj on 4/3/2018.
 */
@Repository
public interface CategoryRepository extends JpaRepository <Category, Long>{

    Category findByName(String name);
}
