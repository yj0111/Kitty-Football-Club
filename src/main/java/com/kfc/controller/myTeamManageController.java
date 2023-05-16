package com.kfc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.Team;
import com.kfc.dto.User;
import com.kfc.service.MyTeamManageService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/teamManage")
@Api(tags = "내 팀 관리 페이지")
public class myTeamManageController {
	@Autowired
	MyTeamManageService myTeamManageService; 
	//멤버 리스트 가져오기
	@GetMapping("/list/{id}")
	public ResponseEntity<?> memberList(@PathVariable int id){
		List<User> list = myTeamManageService.searchMemberList(id);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	//멤버 팀에서 추방하기
	@PutMapping("/kickOut") 
	public ResponseEntity<?> update(@RequestBody int id){
		int result = myTeamManageService.kickOutUser(id);
		if(result !=1) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	
}
