package com.kfc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.Team;
import com.kfc.dto.User;
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
	@GetMapping("/detail2")
	public ResponseEntity<Team> teamDetail2(HttpSession session){
		 User user = (User) session.getAttribute("loginUser");
		 System.out.println("detail2 team" + user);
		 int team_id = user.getTeam_id();
		Team team = detailService.teamDetail(team_id);

		System.out.println("detail2 team" + team);
		if(team == null) {
			return new ResponseEntity<Team>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Team>(team,HttpStatus.OK);
	}
	
	   @PostMapping("/join/{team_id}")
	   public ResponseEntity<Integer> joinTeam(@PathVariable int team_id, HttpSession session){
	      System.out.println("팀아이디!!!!!!!!!!!!!!!!!!!!!!!!!!!"+team_id);
	       User user = (User) session.getAttribute("loginUser");
	       Team jointeam = new Team();
	       System.out.println("유저"+user);
	       jointeam.setId(user.getId());
	       jointeam.setTeam_id(team_id);
	       System.out.println("팀아이디"+team_id);
	       System.out.println("접속아이디"+user.getId());
	       int result = detailService.JoinTeam(jointeam);
	       user.setTeam_id(team_id);
	       return new ResponseEntity<>(result, HttpStatus.CREATED);
	   }


}
