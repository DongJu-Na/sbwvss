package com.sbwvss.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class OpenApiConfig {
	
	public OpenApiConfig() {
		log.info("OpenApiConfig Load");
	}

  @Bean
  public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion) {
  	System.out.println("앱 버전 > " + appVersion);
    Info info = new Info().title("Demo API").version(appVersion)
            .description("Spring Boot를 이용한 Demo 웹 애플리케이션 API입니다.")
            .termsOfService("http://swagger.io/terms/")
            .contact(new Contact().name("ndj").url("test.co.kr").email("djna@enliple.com"))
            .license(new License().name("Apache License Version 2.0").url("http://www.apache.org/licenses/LICENSE-2.0"));

    return new OpenAPI()
            .components(new Components())
            .info(info);
  }

}