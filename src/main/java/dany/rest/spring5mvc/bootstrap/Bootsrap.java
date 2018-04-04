package dany.rest.spring5mvc.bootstrap;

import dany.rest.spring5mvc.domain.Category;
import org.springframework.boot.CommandLineRunner;
import dany.rest.spring5mvc.repository.CategoryRepository;
import org.springframework.stereotype.Component;

/**
 * Created by bautisj on 4/3/2018.
 */
@Component
public class Bootsrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;

    public Bootsrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
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

