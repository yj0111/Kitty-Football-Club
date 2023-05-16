package com.kfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.Team;
import com.kfc.service.TeamDetailService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/teamDetail")
@Api(tags = "팀 상세 컨트롤러")
public class TeamDetailController {

	@Autowired
	TeamDetailService detailService;
	
	@GetMapping("/detail/{team_id}")
	public ResponseEntity<Team> teamDetail(@PathVariable int team_id){
		Team team = detailService.teamDetail(team_id);
		System.out.println(team);
		if(team == null) {
			return new ResponseEntity<Team>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Team>(team,HttpStatus.OK);
	}
}
