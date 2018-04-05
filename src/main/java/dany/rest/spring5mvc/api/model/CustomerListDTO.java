package dany.rest.spring5mvc.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

/**
 * Created by bautisj on 4/5/2018.
 */
@Data
@AllArgsConstructor
public class CustomerListDTO {
    List<CustomerDTO> customers;
}
