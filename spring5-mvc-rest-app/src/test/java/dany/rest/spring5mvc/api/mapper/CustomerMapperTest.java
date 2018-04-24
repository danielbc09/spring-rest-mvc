package dany.rest.spring5mvc.api.mapper;

import com.springframework.model.CustomerDTO;
import dany.rest.spring5mvc.domain.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bautisj on 4/5/2018.
 */
public class CustomerMapperTest {

    public static final long ID = 1l;
    public static final String FIRSTNAME = "John";
    public static final String LASTTNAME = "Doe";
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void customerToCustomerDTO() throws Exception {
    //Given
        Customer customer  = new Customer();
        customer.setFirstname(FIRSTNAME);
        customer.setLastname(LASTTNAME);

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        assertEquals(FIRSTNAME, customerDTO.getFirstname());
        assertEquals(LASTTNAME, customerDTO.getLastname());

    }

    @Test
    public void customerDtoToCustomer() throws  Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(FIRSTNAME);
        customerDTO.setLastname(LASTTNAME);

        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        assertEquals(FIRSTNAME, customerDTO.getFirstname());
        assertEquals(LASTTNAME, customerDTO.getLastname());

    }

}