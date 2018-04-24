package dany.rest.spring5mvc.api.mapper;

import dany.rest.spring5mvc.api.model.VendorDTO;
import dany.rest.spring5mvc.domain.Vendor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bautisj on 4/9/2018.
 */
public class VendorMapperTest {

    public  static final long ID = 1l;
    public static final String NAME = "Compumundo Hipermegared";
    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void vendorToVendorDTO() throws Exception {
        Vendor vendor = new Vendor();
        vendor.setId(ID);
        vendor.setName(NAME);

        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
        assertEquals(NAME, vendorDTO.getName());
    }

    @Test
    public void vendorDtoToVendor() throws Exception {
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);

        assertEquals(NAME, vendor.getName());
    }

}