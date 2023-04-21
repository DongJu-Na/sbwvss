package com.sbwvss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbwvss.service.ApiService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Tag(name = "Video API", description = "동영상 관련 컨트롤러")
@RequestMapping("/api")
@Slf4j
@RestController
public class ApiController {
	
	@Autowired
	ApiService service;
	
	/*
	Accept-Ranges: bytes
	Content-Type: video/mp4
	Content-Range: bytes 0-500/21589849
	Content-Length: 501
	*/
	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "성공") })
  @GetMapping(value = "/video/{title}", produces = "video/mp4")
  public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range) {
      log.info("range > " + range);
      return service.getVideo(title);
  }
  
}
