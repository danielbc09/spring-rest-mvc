package dany.rest.spring5mvc.controllers.v1;

import dany.rest.spring5mvc.api.model.VendorDTO;
import dany.rest.spring5mvc.repository.VendorRepository;
import dany.rest.spring5mvc.services.VendorService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VendorControllerTest {

    public static final long ID = 1l;
    public static final String VENDOR_NAME = "Western Tasty Fruits Ltd.";
    @Mock
    VendorService vendorService;

    @InjectMocks
    VendorController vendorController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vendorController)
                    .setControllerAdvice(new RestResponseEntityExceptionHandler())
                    .build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllVendors() throws Exception {
        VendorDTO vendorDTO1 = new VendorDTO();
        vendorDTO1.setId(ID);
        vendorDTO1.setName(VENDOR_NAME);

        VendorDTO vendorDTO2 = new VendorDTO();
        vendorDTO2.setId(1l);
        vendorDTO2.setName("Exotic Fruits Company");

        List<VendorDTO> vendorDTOS = Arrays.asList(vendorDTO1,vendorDTO2);

        when(vendorService.getAllVendors()).thenReturn(vendorDTOS);

        mockMvc.perform(get(VendorController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getVendorById() throws Exception{
        //Given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setId(ID);
        vendorDTO.setName(VENDOR_NAME);
        vendorDTO.setVendorUrl(VendorController.BASE_URL + "/1");
        when(vendorService.getVendorById(anyLong())).thenReturn(vendorDTO);
        //When
        mockMvc.perform(get(VendorController.BASE_URL+ "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(VENDOR_NAME)))
                .andExpect(jsonPath("$.vendor_url", equalTo("/api/v1/vendors/1")));
    }

}