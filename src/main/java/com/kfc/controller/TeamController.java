package com.kfc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.Team;
import com.kfc.dto.User;
import com.kfc.service.TeamService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/team")
@Api(tags = "팀 생성 및 목록검색 컨트롤러")
public class TeamController {
	
	@Autowired
	TeamService teamservice;
	//팀생성
	@PostMapping("/create")
	public ResponseEntity<Integer> signup(Team team ,HttpSession session) {
		User user = (User) session.getAttribute("loginUser");
		int id = user.getId();
		int result = teamservice.creatTeam(team, id);
		
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	//팀 목록 가져오기
	@GetMapping("/list")
	public ResponseEntity<?> teamlist(@RequestParam(required = false) String word){
		if(word == null) {
			word ="none";
		}
		List<Team> list = teamservice.searchList(word);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Team>>(list, HttpStatus.OK);
	}
}
