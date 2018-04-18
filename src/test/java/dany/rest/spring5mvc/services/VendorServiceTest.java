package dany.rest.spring5mvc.services;

import dany.rest.spring5mvc.api.mapper.VendorMapper;
import dany.rest.spring5mvc.api.model.VendorDTO;
import dany.rest.spring5mvc.api.model.VendorListDTO;
import dany.rest.spring5mvc.domain.Vendor;
import dany.rest.spring5mvc.repository.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class VendorServiceTest {

    private static final String VENDOR1_NAME = "Exotic Fruits Company";
    private static final Long VENDOR1_ID = 1L;
    private static final String VENDOR2_NAME = "Home Fruits";
    private static final Long VENDOR2_ID = 2L;

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
        VendorListDTO vendorListDTO = vendorService.getAllVendors();

        //Then
        then(vendorRepository).should(times(1)).findAll();
    }

    @Test
    public void getVendorById() throws Exception {
        //Given
        Vendor vendor = getVendor1();
        //Mockito BDD Syntax
        given(vendorRepository.findById(anyLong())).willReturn(Optional.of(vendor));
        //When
        VendorDTO vendorDTO = vendorService.getVendorById(1L);
        //Then
        then(vendorRepository).should(times(1)).findById(anyLong());
        assertThat(vendorDTO.getName(), is(equalTo(VENDOR1_NAME)));
    }


    private Vendor getVendor1() {
        Vendor vendor = new Vendor();
        vendor.setName(VENDOR1_NAME);
        vendor.setId(VENDOR1_ID);
        return vendor;
    }

    private Vendor getVendor2() {
        Vendor vendor = new Vendor();
        vendor.setName(VENDOR2_NAME);
        vendor.setId(VENDOR2_ID);
        return vendor;
    }
}