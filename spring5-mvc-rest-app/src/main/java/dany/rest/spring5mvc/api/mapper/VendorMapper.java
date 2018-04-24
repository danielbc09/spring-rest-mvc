package dany.rest.spring5mvc.api.mapper;

import dany.rest.spring5mvc.api.model.VendorDTO;
import dany.rest.spring5mvc.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by bautisj on 4/9/2018.
 */
@Mapper
public interface VendorMapper {
    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendorDTO(Vendor vendor);

    Vendor vendorDtoToVendor(VendorDTO vendorDTO);
}
