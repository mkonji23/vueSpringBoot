package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	/**
	 * 스웨거 API
	 * **/
	
	@Bean
	public Docket api() {
		// api마다 토큰추가하는거임
		List<Parameter> global = new ArrayList<>();
		global.add(new ParameterBuilder().name("Authorization")
	    .description("Access Token")
	    .parameterType("header")
	    .required(false)
	    .modelRef(new ModelRef("string")).build());
		
		
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(this.swaggerInfo()) //스웨거 정보 등록
			.select()
			.apis(RequestHandlerSelectors.any()) // 모든 Controller들이 있는 패키지를 탐색해서 API문서를 만든다.
			.paths(PathSelectors.any())
			.build()
			.useDefaultResponseMessages(true) // 기본으로 세팅되는 200, 401,403,404 메시지 표기
//			.globalOperationParameters(global)
//			.securityContexts(Arrays.asList(securityContext()))
			.securitySchemes(Arrays.asList(apiKey())) //헤더 토큰
			.securityContexts(Arrays.asList(securityContext())); //토큰 내용 

	}
	/**
	 * 스웨거 정보
	 */
	private ApiInfo swaggerInfo() {
		return new ApiInfoBuilder()
				.title("Spring Boot API Documentation")
				.description("Spring Boot 연습용 프로젝트")
				.version("1.0.0")
				.build();
	}
	
	private SecurityContext securityContext() {
        return springfox
                .documentation
                .spi.service
                .contexts
                .SecurityContext
                .builder()
                .securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
    }
	
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("apiKey", authorizationScopes));
    }
	
	private ApiKey apiKey()
	{
			return new ApiKey("apiKey", "Authorization","header");
	}
}
