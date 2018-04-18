package dany.rest.spring5mvc.bootstrap;

import dany.rest.spring5mvc.domain.Category;
import dany.rest.spring5mvc.domain.Customer;
import dany.rest.spring5mvc.domain.Vendor;
import dany.rest.spring5mvc.repository.CategoryRepository;
import dany.rest.spring5mvc.repository.CustomerRepository;
import dany.rest.spring5mvc.repository.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by bautisj on 4/3/2018.
 */
@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        loadCustomers();
        loadCategories();
        loadVendors();

    }

    private void loadVendors() {
        Vendor vendor = new Vendor();
        vendor.setName("Western Tasty Fruits Ltd.");

        Vendor vendor2 = new Vendor();
        vendor2.setName("Exotic Fruits Company");

        Vendor vendor3 = new Vendor();
        vendor3.setName("Home Fruits");

        Vendor vendor4 = new Vendor();
        vendor4.setName("Fun Fresh Fruits Ltd.");

        Vendor vendor5 = new Vendor();
        vendor5.setName("Nuts for Nuts Company");

        vendorRepository.save(vendor);
        vendorRepository.save(vendor2);
        vendorRepository.save(vendor3);
        vendorRepository.save(vendor4);
        vendorRepository.save(vendor5);

        System.out.println("**********************Vendors Loaded****************************"+ vendorRepository.count());

    }

    public void loadCategories() {
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

    public void loadCustomers() {
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

