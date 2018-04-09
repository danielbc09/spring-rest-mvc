package dany.rest.spring5mvc.services;


import dany.rest.spring5mvc.api.mapper.CustomerMapper;
import dany.rest.spring5mvc.api.model.CustomerDTO;
import dany.rest.spring5mvc.domain.Customer;
import dany.rest.spring5mvc.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by bautisj on 4/5/2018.
 */
public class CustomerServiceTest {

    public static final String FIRST_NAME = "Jhon";
    public static final String LAST_NAME = "Doe";
    public static final long ID = 1l;
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void getAllCustomers() throws Exception {
        //Given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());
        when(customerRepository.findAll()).thenReturn(customers);

        //When
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //Then
        assertEquals(3, customerDTOS.size());
    }

    @Test
    public void getCustomerByName() {
        //Given
        Customer jhon = new Customer();
        jhon.setId(ID);
        jhon.setFirstname(FIRST_NAME);
        jhon.setLastname(LAST_NAME);
        when(customerRepository.findByFirstname(anyString())).thenReturn(jhon);

        //When
        CustomerDTO customerDTO = customerService
                .getCustomerByName(FIRST_NAME);

        assertEquals(FIRST_NAME, customerDTO.getFirstname());
        assertEquals(LAST_NAME, customerDTO.getLastname());
        assertEquals(Long.valueOf(ID), customerDTO.getId());

    }

    @Test
    public void createCustomer() {
        //Given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(FIRST_NAME);
        customerDTO.setLastname(LAST_NAME);

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstname(customerDTO.getFirstname());
        savedCustomer.setLastname(customerDTO.getLastname());
        savedCustomer.setId(1l);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        //When
        CustomerDTO savedDto = customerService.createCustomer(customerDTO);

        //Theb
        assertEquals(customerDTO.getFirstname(), savedDto.getFirstname());
        assertEquals("/api/v1/customer/1", savedDto.getCustomerUrl());
    }

    @Test
    public void saveCustomerByDTOTest() throws  Exception {
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstname(customerDTO.getFirstname());
        savedCustomer.setLastname(customerDTO.getLastname());
        savedCustomer.setId(1l);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        //when
        CustomerDTO savedDto = customerService.saveCustomerByDTO(1L, customerDTO);

        //then
        assertEquals(customerDTO.getFirstname(), savedDto.getFirstname());
        assertEquals("/api/v1/customer/1", savedDto.getCustomerUrl());
    }
}