package dany.rest.spring5mvc.services;


import com.springframework.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bautisj on 4/5/2018.
 */
@Service
public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByName(String name);

    CustomerDTO getCustomerById(Long id);

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomerByID(Long id);

    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

}
