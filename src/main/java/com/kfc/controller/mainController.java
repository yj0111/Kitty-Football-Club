package com.kfc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.Game;
import com.kfc.dto.Team;
import com.kfc.service.MainService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/main")
@Api(tags = "메인 컨트롤러")
public class mainController {
	@Autowired
	MainService mainService;
	
	//최근 2개 경기 결과 보여주기
	@GetMapping("/record")
	public ResponseEntity<?> record(){
	
		List<Game> list = mainService.searchRecord();
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Game>>(list, HttpStatus.OK);
	}
	//앞으로 3일간의 경기 보여주기
	@GetMapping("/gameList")
	public ResponseEntity<?> gameList(){
		HashMap <String, List<Game>> map = new HashMap<String, List<Game>>();
		 map = mainService.gameList();
		
		return new ResponseEntity<HashMap <String, List<Game>>>(map, HttpStatus.OK);
	}
	
	@GetMapping("/recordOne")
	public ResponseEntity<?> recordLimit(){
	
		Game list = mainService.searchRecordOne();
		if(list == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Game>(list, HttpStatus.OK);
	}
}
