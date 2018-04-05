package dany.rest.spring5mvc.api.model;

import lombok.Data;

/**
 * Created by bautisj on 4/5/2018.
 */
@Data
public class CustomerDTO {

   private Long id;
   private String firstname;
   private String lastName;
   private String customerUrl;
}
