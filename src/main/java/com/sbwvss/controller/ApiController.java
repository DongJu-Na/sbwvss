package com.sbwvss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sbwvss.service.ApiService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class ApiController {
	
	@Autowired
	ApiService service;
	
  @GetMapping(value = "video/{title}", produces = "video/mp4")
  public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range) {
      log.info("range > " + range);
      return service.getVideo(title);
  }
  
}
