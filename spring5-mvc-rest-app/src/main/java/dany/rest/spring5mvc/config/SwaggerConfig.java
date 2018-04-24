package dany.rest.spring5mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by bautisj on 4/19/2018.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig{ //set-up manually swagger resources extends WebMvcConfigurationSupport{

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());
    }

/*  for a custom configuration
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars*//**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }*/

     private ApiInfo metaData() {
         Contact contact = new Contact("Daniel B", "http://www.google.com", "jdanielbc193@gmail.com");

         return new ApiInfo(
                 "Spring Rest Api V1",
                 "Spring Framerwork 5 with Rest",
                 "1.0",
                 "TermsofServioce: blah",
                  contact,
                 "Apache License Version 2.0",
                 "https://www.apache.org/licenses/LICENSE-2.0",
                 new ArrayList<>());
     }
}
