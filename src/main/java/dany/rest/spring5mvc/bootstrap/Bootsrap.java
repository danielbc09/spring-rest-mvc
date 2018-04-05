package dany.rest.spring5mvc.bootstrap;

import dany.rest.spring5mvc.domain.Category;
import dany.rest.spring5mvc.domain.Customer;
import dany.rest.spring5mvc.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import dany.rest.spring5mvc.repository.CategoryRepository;
import org.springframework.stereotype.Component;

/**
 * Created by bautisj on 4/3/2018.
 */
@Component
public class Bootsrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootsrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
       /***CUSTOMERS***/
        Customer jhonDoe = new Customer();
        jhonDoe.setFirstName("Jhon");
        jhonDoe.setLastName("Doe");

        Customer danyB = new Customer();
        danyB.setFirstName("Dany");
        danyB.setLastName("Boy");

        Customer laraC = new Customer();
        laraC.setFirstName("Lara");
        laraC.setLastName("Croft");

        Customer chew = new Customer();
        chew.setFirstName("Chew");
        chew.setLastName("Baka");

        customerRepository.save(jhonDoe);
        customerRepository.save(danyB);
        customerRepository.save(laraC);
        customerRepository.save(chew);

      /***CATEGORIES***/
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(nuts);
        categoryRepository.save(fresh);

        System.out.println("**********************Data Loaded****************************"+ categoryRepository.count());

    }
}

