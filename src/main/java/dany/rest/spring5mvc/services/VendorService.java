package dany.rest.spring5mvc.services;

import dany.rest.spring5mvc.api.model.VendorDTO;

import java.util.List;

public interface VendorService {
    List<VendorDTO> getAllVendors();
}
