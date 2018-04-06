package dany.rest.spring5mvc.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by bautisj on 4/5/2018.
 */
@Data
public class CustomerDTO {

   private Long id;
   private String firstname;
   private String lastname;
   @JsonProperty("customer_url")
   private String customerUrl;
}
