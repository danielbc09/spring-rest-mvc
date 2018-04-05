package dany.rest.spring5mvc.repository;

import dany.rest.spring5mvc.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bautisj on 4/5/2018.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Customer findByFirstName(String name);
}
