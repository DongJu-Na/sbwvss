package com.sbwvss;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;

import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class SbwvssApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SbwvssApplication.class, args);
	}

	@SuppressWarnings("unused")
	@Override
	public void run(String... args) throws Exception {
		//CommandLineRunner 인터페이스를 구현하여 데이터 버퍼를 생성하는 공장 클래스의 인스턴스를 생성
		DefaultDataBufferFactory sharedInstance = DefaultDataBufferFactory.sharedInstance;
	}
	
	@Bean
	public GroupedOpenApi tweetsOpenApi(@Value("${springdoc.version}") String appVersion) {
		String[] paths = { "/tweets/**" };
		return GroupedOpenApi.builder().
				group("tweets")
				.addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Tweets API").version(appVersion)))
				.pathsToMatch(paths)
				.build();
	}

	@Bean
	public GroupedOpenApi streamOpenApi(@Value("${springdoc.version}") String appVersion) {
		String[] paths = { "/stream/**" };
		String[] packagedToMatch = { "org.springdoc.demo.app3" };
		return GroupedOpenApi.builder().group("x-stream")
				.addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Stream API").version(appVersion)))
				.pathsToMatch(paths).packagesToScan(packagedToMatch)
				.build();
	}
	
}
