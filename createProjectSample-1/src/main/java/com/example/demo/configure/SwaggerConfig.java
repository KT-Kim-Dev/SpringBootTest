package com.example.demo.configure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.globalResponseMessage(RequestMethod.GET, getArrayList())
				.globalResponseMessage(RequestMethod.POST, getArrayList())
				.apiInfo(apiInfo("exampleTest_v1", "v1"));
	}

	private List<ResponseMessage> getArrayList() {
		List<ResponseMessage> lists = new ArrayList<ResponseMessage>();
		lists.add(new ResponseMessageBuilder().code(500).message("서버에러").responseModel(new ModelRef("Error")).build());
		lists.add(new ResponseMessageBuilder().code(403).message("권한없음").responseModel(new ModelRef("Forbbiden")).build());
		return lists;
	}

	private ApiInfo apiInfo(String title, String version) {
		return new ApiInfo(title, "Swagger로 생성한 API Docs", version, "www.example.com",
				new Contact("Contact Me", "www.example.com", "foo@example.com"), "Licenses", "www.example.com",
				new ArrayList<>());
	}

}
