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

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
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

    @Test(expected = ResourceNotFoundException.class)
    public void getVendorByIdNotFound() throws Exception {
        //given
        //mockito BBD syntax since mockito 1.10.0
        given(vendorRepository.findById(anyLong())).willReturn(Optional.empty());

        //when
        VendorDTO vendorDTO = vendorService.getVendorById(1L);

        //then
        then(vendorRepository).should(times(1))
                .findById(anyLong());
    }

    @Test
    public void createNewVendor() throws Exception {
        //Given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(VENDOR1_NAME);
        Vendor vendor = getVendor1();
        given(vendorRepository.save(any(Vendor.class))).willReturn(vendor);
        //When
        VendorDTO savedVedorDTO = vendorService.createNewVendor(vendorDTO);
        //Then
        then(vendorRepository).should().save(any(Vendor.class));
        assertThat(savedVedorDTO.getVendorUrl(), containsString("1"));
    }

    @Test
    public void updateVendorByDTO() throws Exception {
        //Given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(VENDOR1_NAME);

        Vendor vendor = getVendor1();
        given(vendorRepository.save(any(Vendor.class))).willReturn(vendor);

        //When
        VendorDTO savedVendorDTO = vendorService.updateVendorByDTO(VENDOR1_ID, vendorDTO);

        then(vendorRepository).should().save(any(Vendor.class));
        assertThat(savedVendorDTO.getVendorUrl(), containsString("1"));
    }

    @Test
    public void patchVendor() throws Exception {
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(VENDOR1_NAME);

        Vendor vendor = getVendor1();

        given(vendorRepository.findById(anyLong())).willReturn(Optional.of(vendor));
        given(vendorRepository.save(any(Vendor.class))).willReturn(vendor);

        //when

        VendorDTO savedVendorDTO = vendorService.patchVendor(VENDOR1_ID, vendorDTO);

        //then
        // 'should' defaults to times = 1
        then(vendorRepository).should().save(any(Vendor.class));
        then(vendorRepository).should(times(1)).findById(anyLong());
        assertThat(savedVendorDTO.getVendorUrl(), containsString("1"));
    }

    @Test
    public void deleteVendorById()throws Exception {
        //when
        vendorService.deleteVendor(1L);
        //then
        then(vendorRepository).should().deleteById(anyLong());
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