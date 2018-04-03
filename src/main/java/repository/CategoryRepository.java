package repository;

import domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bautisj on 4/3/2018.
 */
public interface CategoryRepository extends JpaRepository <Category, Long>{

}
