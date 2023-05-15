package com.kfc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.Team;
import com.kfc.dto.User;
import com.kfc.service.TeamService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/team")
@Api(tags = "팀 생성 및 목록검색 컨트롤러")
public class TeamCreateController {
	
	@Autowired
	TeamService teamservice;
	//테스트 주석2
	@PostMapping("/create")
	public ResponseEntity<Integer> signup(Team team ,HttpSession session) {
		User user = (User) session.getAttribute("loginUser");
		int id = user.getId();
		int result = teamservice.creatTeam(team, id);
		
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
}
