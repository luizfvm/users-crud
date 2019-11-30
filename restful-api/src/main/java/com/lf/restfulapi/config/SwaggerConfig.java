package com.lf.restfulapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig class responsible for implementing Swagger UI.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.lf.restfulapi")).paths(PathSelectors.regex("/users.*"))
				.build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("RESTful API")
				.description("In this web service you can POST, GET, PUT and DELETE data from Users")
				.contact(new Contact("Luiz Felipe", null, "vaccari.lf@gmail.com")).license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version(null).build();
	}

}
