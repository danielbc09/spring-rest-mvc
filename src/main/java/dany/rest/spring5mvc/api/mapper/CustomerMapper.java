package dany.rest.spring5mvc.api.mapper;

import dany.rest.spring5mvc.api.model.CustomerDTO;
import dany.rest.spring5mvc.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by bautisj on 4/5/2018.
 */
@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source="id", target= "id")
    CustomerDTO customerToCustomerDTO(Customer customer);
}
