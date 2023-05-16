package com.kfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.Gather;
import com.kfc.service.GatherService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/gather")
@Api(tags = "게임 모집 컨트롤러")
public class GatherController {

	@Autowired
	GatherService gatherService;

	//모집 공고 만들기 
	@PostMapping("/make")
//	int gather(Gather gather);/
	public ResponseEntity<Integer> gather(Gather gather) {		
		int result = gatherService.gather(gather);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
}
