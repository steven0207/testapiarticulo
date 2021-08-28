package com.mx.test.rest.eaj.articulo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class SpringFoxConfig {

	   @Bean
	    public Docket api() { 
	        return new Docket (DocumentationType.SWAGGER_2)  
	          .select()
	          .apis(RequestHandlerSelectors.basePackage("com.mx.test.rest.eaj.articulo.api"))
	          .paths(PathSelectors.any())
	          .build();                                           
	    }
	   
	   private ApiInfo apinfo() {
	        return new ApiInfoBuilder()
	                .title("User Management API")
	                .description("Rest API to Perfrom CURD ")
	                .termsOfServiceUrl("Some Terms of Services URL")
	                .version("1.0.0")
	                .license("Some License Info")
	                .licenseUrl("Some License URL")
	                .contact(new Contact("Esteban Alcantara", "https://nirajsonawane.github.io/","esteban.alcantara@gmail.com"))
	                .build();
	    }
	   
	 
}
