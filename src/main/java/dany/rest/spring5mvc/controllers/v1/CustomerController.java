package dany.rest.spring5mvc.controllers.v1;

import dany.rest.spring5mvc.api.model.CustomerDTO;
import dany.rest.spring5mvc.api.model.CustomerListDTO;
import dany.rest.spring5mvc.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bautisj on 4/5/2018.
 */
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static  final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getAllCategories() {
        return new CustomerListDTO(customerService.getAllCustomers());
    }
/*
    @GetMapping("/{name}")
    public ResponseEntity<CustomerDTO> getCustomerByName(@PathVariable String name){
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerByName(name), HttpStatus.OK
        );
    }
*/
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO creteNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomerByDTO(id, customerDTO);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return customerService.patchCustomer(id, customerDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerByID(id);
    }
}
