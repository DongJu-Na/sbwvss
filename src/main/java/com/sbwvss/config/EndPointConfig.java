package com.sbwvss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sbwvss.service.ApiService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class EndPointConfig {
	

  @Autowired
  private ApiService service;

  @Bean
  public RouterFunction<ServerResponse> router(){
      return RouterFunctions.route()
              .GET("fun-ep/video/{title}", this::videoHandler)
              .build();
  }

  private Mono<ServerResponse> videoHandler(ServerRequest serverRequest){
      String title = serverRequest.pathVariable("title");
      log.info("videoHandler > " + title);
      return ServerResponse.ok()
              .contentType(MediaType.valueOf("video/mp4"))
              .body(this.service.getVideo(title), Resource.class);
  }
  
}
