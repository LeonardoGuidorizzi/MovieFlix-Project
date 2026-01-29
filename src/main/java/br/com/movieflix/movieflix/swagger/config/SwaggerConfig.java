package br.com.movieflix.movieflix.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI getOpenAPI (){

        Contact contact = new Contact();
        contact.email("leonardoguidorizzi.moreira@gmail.com");

        Info info = new Info();
        info.title("Movieflix");
        info.description("Aplicação para gerenciamento de catalogo de filmes");
        info.version("v1");
        info.contact(contact);
        return new OpenAPI().info(info);
    }
}
