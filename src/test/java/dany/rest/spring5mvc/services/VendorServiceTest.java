package dany.rest.spring5mvc.services;

import dany.rest.spring5mvc.api.mapper.CustomerMapper;
import dany.rest.spring5mvc.api.mapper.VendorMapper;
import dany.rest.spring5mvc.api.model.VendorDTO;
import dany.rest.spring5mvc.domain.Vendor;
import dany.rest.spring5mvc.repository.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class VendorServiceTest {

    private static final  String VENDOR_NAME = "Exotic Fruits Company";
    VendorService vendorService;

    @Mock
    VendorRepository vendorRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        vendorService = new VendorServiceImpl(VendorMapper.INSTANCE, vendorRepository);
    }

    @Test
    public void getAllVendors() throws Exception {
        //Given
        List<Vendor> vendors = Arrays.asList(new Vendor(), new Vendor(), new Vendor());
        when(vendorRepository.findAll()).thenReturn(vendors);

        //When
        List<VendorDTO> vendorDTOS = vendorService.getAllVendors();

        //Then
        assertEquals(3, vendorDTOS.size());
    }

}