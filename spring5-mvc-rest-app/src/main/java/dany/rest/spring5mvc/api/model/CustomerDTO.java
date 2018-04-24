package dany.rest.spring5mvc.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by bautisj on 4/5/2018.
 */
@Data
public class CustomerDTO {

   private Long id;
   @ApiModelProperty(value = "This is the first name client", required = true)
   private String firstname;
   @ApiModelProperty(value = "This is the last name client", required = true)
   private String lastname;
   @ApiModelProperty(value = "This is the route of the client")
   @JsonProperty("customer_url")
   private String customerUrl;
}
