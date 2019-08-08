package poc.sb.apifirst.oas30.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

//@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * avoid scanning all the project
     * TODO: verify this
     */
    /*@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.none())
                .paths(PathSelectors.none())
                .build();
    }*/

    /**
     * api first...
     *
     */
    /*@Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider() {
        return () -> {
            SwaggerResource wsResource = new SwaggerResource();
            wsResource.setName("default");
            wsResource.setSwaggerVersion("2.0");
            wsResource.setLocation("/oas3/api.yaml");

            List<SwaggerResource> resources = new ArrayList<>();
            resources.add(wsResource);
            return resources;
        };
    }*/
}