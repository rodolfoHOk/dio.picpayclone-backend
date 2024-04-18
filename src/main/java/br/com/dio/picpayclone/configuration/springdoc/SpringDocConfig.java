package br.com.dio.picpayclone.configuration.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringDocConfig {

    @Value("${spring.api.version}")
    private String apiVersion;

    @Bean
    public OpenAPI openAPI() {
        final String securitySchemeName = "Authorization";

        return new OpenAPI()
                .info(new Info()
                        .title("PicPayClone API")
                        .description("Estrutura de uma API RestFull com Spring Boot para simular funcionalidades do PicPay")
                        .version(apiVersion)
                ).tags(Arrays.asList(
                                new Tag().name("Transações").description("Operações relacionadas a Transações"),
                                new Tag().name("Usuários").description("Operações relacionadas a Usuários"),
                                new Tag().name("Autenticação").description("Operações relacionadas a Autenticação")
                        )
                ).addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName)
                ).components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("Bearer")
                                .bearerFormat("JWT")
                        )
                );
    }
}
