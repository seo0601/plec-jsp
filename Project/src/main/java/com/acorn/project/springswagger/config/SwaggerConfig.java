package com.acorn.project.springswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	  @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(this.swaggerInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.acorn.project"))
	                .paths(PathSelectors.any())
	                .build()
	                .useDefaultResponseMessages(true);
	    }

	    private ApiInfo swaggerInfo() {
	        return new ApiInfoBuilder()
	                .title("Spring Boot Api Documentation")
	                .description("practice swagger config")
	                .version("1.0")
	                .build();
	    }
    

}