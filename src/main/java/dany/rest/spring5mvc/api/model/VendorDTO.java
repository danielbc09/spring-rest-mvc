package dany.rest.spring5mvc.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by bautisj on 4/9/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {

    private String name;
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
