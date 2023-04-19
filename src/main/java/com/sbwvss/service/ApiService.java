package com.sbwvss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ApiService {
  private static final String FORMAT = "classpath:videos/%s.mp4";

  @Autowired
  private ResourceLoader resourceLoader;

  public Mono<Resource> getVideo(String title) {
  	  log.info("title > " + title);
      return Mono.fromSupplier(() -> this.resourceLoader.getResource( String.format(FORMAT, title)));
  }
  
}
