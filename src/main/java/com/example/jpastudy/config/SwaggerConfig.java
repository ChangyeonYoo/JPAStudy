package com.example.jpastudy.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiV1(){
        String version1 = "1.0";
        String version = version1;
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(version))
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.
                        basePackage("com.example.jpastudy.controller"))
                .paths(Predicates.or(PathSelectors.regex("^(?!/v2).+"))).build().
                securitySchemes(apiKey());
    }

    private List<ApiKey> apiKey() {
        List<ApiKey> list = new ArrayList<>();
        String tokenUserName = "Authorization";
        list.add(new ApiKey("Bearer +accessToken", tokenUserName, "header"));
        String tokenCsrfName = "X-CSRF-TOKEN";
        list.add(new ApiKey(tokenCsrfName, tokenCsrfName, "header"));
        return list;
    }

    private ApiInfo apiInfo(String version) {
        String title = "JPA Study API";
        return new ApiInfoBuilder()
                .title(title + " " +version)
                .description("API Doc for " + title)
                .version(version)
                .build();
    }

}

