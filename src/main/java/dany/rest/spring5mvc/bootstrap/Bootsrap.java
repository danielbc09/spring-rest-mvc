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

        loadCustomers();
        loadCategories();

    }

    private void loadCategories() {
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

        System.out.println("**********************Categories Loaded****************************"+ categoryRepository.count());
    }

    private void loadCustomers() {
        Customer jhonDoe = new Customer();
        jhonDoe.setFirstname("Jhon");
        jhonDoe.setLastname("Doe");

        Customer danyB = new Customer();
        danyB.setFirstname("Dany");
        danyB.setLastname("Boy");

        Customer laraC = new Customer();
        laraC.setFirstname("Lara");
        laraC.setLastname("Croft");

        Customer chew = new Customer();
        chew.setFirstname("Chew");
        chew.setLastname("Baka");

        customerRepository.save(jhonDoe);
        customerRepository.save(danyB);
        customerRepository.save(laraC);
        customerRepository.save(chew);
        System.out.println("**********************Customers Loaded****************************"+ categoryRepository.count());

    }
}

