package dany.rest.spring5mvc.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by bautisj on 4/6/2018.
 */
public abstract class AbstractRestControllerTest {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
