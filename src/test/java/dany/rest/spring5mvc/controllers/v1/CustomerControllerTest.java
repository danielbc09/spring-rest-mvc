package dany.rest.spring5mvc.controllers.v1;

import dany.rest.spring5mvc.api.model.CustomerDTO;
import dany.rest.spring5mvc.domain.Customer;
import dany.rest.spring5mvc.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by bautisj on 4/5/2018.
 */
public class CustomerControllerTest {

    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void getAllCategories() throws Exception {
        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setId(1l);
        customerDTO1.setFirstName("Jhon");
        customerDTO1.setLastName("Doe");

        CustomerDTO customerDTO2 = new CustomerDTO();
        customerDTO1.setId(2l);
        customerDTO1.setFirstName("Jenny");
        customerDTO1.setLastName("Foo");

        List<CustomerDTO> customers = Arrays.asList(customerDTO1, customerDTO2);
        when(customerService.getAllCustomers()).thenReturn(customers);

        mockMvc.perform(get("/api/v1/customers/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.users", equalTo("Jhon")));

    }

}