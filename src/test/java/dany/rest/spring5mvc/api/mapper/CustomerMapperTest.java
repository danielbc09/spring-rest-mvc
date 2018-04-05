package dany.rest.spring5mvc.api.mapper;

import dany.rest.spring5mvc.api.model.CustomerDTO;
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
        customer.setId(1l);
        customer.setFirstname(FIRSTNAME);
        customer.setLastname(LASTTNAME);

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        assertEquals(Long.valueOf(ID), customerDTO.getId());
        assertEquals(FIRSTNAME, customerDTO.getFirstname());
        assertEquals(LASTTNAME, customerDTO.getLastName());

    }

}