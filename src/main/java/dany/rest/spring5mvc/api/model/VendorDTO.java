package dany.rest.spring5mvc.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by bautisj on 4/9/2018.
 */
@Data
public class VendorDTO {
    private Long id;
    private String name;
    @JsonProperty("vendor_url")
    private String customerUrl;
}
