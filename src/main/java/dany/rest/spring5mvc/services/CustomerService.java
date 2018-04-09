package dany.rest.spring5mvc.services;

import dany.rest.spring5mvc.api.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bautisj on 4/5/2018.
 */
@Service
public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByName(String name);

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(Long id);

    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);
}
