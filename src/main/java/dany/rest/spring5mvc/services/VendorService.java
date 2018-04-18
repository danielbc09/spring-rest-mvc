package dany.rest.spring5mvc.services;

import dany.rest.spring5mvc.api.model.VendorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VendorService {
    List<VendorDTO> getAllVendors();

    VendorDTO getVendorById(Long id);
}
