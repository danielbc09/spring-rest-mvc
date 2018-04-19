package dany.rest.spring5mvc.services;

import dany.rest.spring5mvc.api.model.VendorDTO;
import dany.rest.spring5mvc.api.model.VendorListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VendorService {
    VendorListDTO getAllVendors();

    VendorDTO getVendorById(Long id);

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO updateVendorByDTO(Long id, VendorDTO vendorDTO);
}
