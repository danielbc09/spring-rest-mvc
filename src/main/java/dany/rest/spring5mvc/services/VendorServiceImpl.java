package dany.rest.spring5mvc.services;

import dany.rest.spring5mvc.api.mapper.VendorMapper;
import dany.rest.spring5mvc.api.model.VendorDTO;
import dany.rest.spring5mvc.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService{

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl("/api/vendors/" + vendor.getId());
                    return vendorDTO;
                })
                .collect(Collectors.toList());
    }
}
