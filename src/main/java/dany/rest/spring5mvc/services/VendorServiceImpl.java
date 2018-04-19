package dany.rest.spring5mvc.services;

import dany.rest.spring5mvc.api.mapper.VendorMapper;
import dany.rest.spring5mvc.api.model.VendorDTO;
import dany.rest.spring5mvc.api.model.VendorListDTO;
import dany.rest.spring5mvc.controllers.v1.VendorController;
import dany.rest.spring5mvc.domain.Vendor;
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
    public VendorListDTO getAllVendors() {
         List<VendorDTO> vendorDTOS = vendorRepository.findAll()
                .stream()
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl("/api/vendors/" + vendor.getId());
                    vendorDTO.setVendorUrl(getVendorUrl(vendor.getId()));
                    return vendorDTO;
                })
                .collect(Collectors.toList());

         return new VendorListDTO(vendorDTOS);
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository
                .findById(id)
                .map(vendorMapper::vendorToVendorDTO)
                .map(vendorDto -> {
                    vendorDto.setVendorUrl(getVendorUrl(id));
                    return vendorDto;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        return savedAndReturnDTO(vendorMapper.vendorDtoToVendor(vendorDTO));
    }

    private VendorDTO savedAndReturnDTO(Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(savedVendor);
        vendorDTO.setVendorUrl(getVendorUrl(savedVendor.getId()));
        return vendorDTO;
    }

    private String getVendorUrl(Long id) {
        return VendorController.BASE_URL + "/" +id;
    }
}
