package br.com.dfdx.restapi;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

		@Bean
		public Docket apiConfigDocs() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("br.com.dfdx.restapi.resources"))
					.paths(PathSelectors.any())
					.build();
			
		}
		
		private ApiInfo infoDocs() {
			return new ApiInfo(
					"Demo Rest API" , 
					"Rest API criada para demonstrar o uso do Spring Boot", 
					"1", 
					"http://www.dfdx.com.br", 
					new Contact("Louro Jose", "http://www.dfdx.com.br", "lourojose@dfdx.com.br"), 
					"Apache", 
					"http://apache.org", 
					new ArrayList<VendorExtension>());
		}
}
