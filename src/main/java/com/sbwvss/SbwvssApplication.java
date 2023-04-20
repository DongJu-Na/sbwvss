package com.sbwvss;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;

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
	

	
}
