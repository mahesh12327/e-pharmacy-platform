package com.ardent.mailorderpharmacy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mail Order Pharmacy API")
                        .version("1.0")
                        .description("API documentation for the Mail Order Pharmacy project")
                        .contact(new Contact()
                                .name("Maheswar Reddy Gajjala")
                                .email("maheswarreddy700@gmail.com")
                                .url("https://www.linkedin.com/in/maheswar-reddy-gajjala-316151169/")));
    }
}
