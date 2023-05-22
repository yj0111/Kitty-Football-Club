package com.kfc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.kfc.service.LoginService;
import com.kfc.service.MyTeamManageService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/teamManage")
@Api(tags = "내 팀 관리 페이지")
public class myTeamManageController {
	@Autowired
	LoginService loginService; 
	@Autowired
	MyTeamManageService myTeamManageService; 
	//멤버 리스트 가져오기
	@GetMapping("/list")
	public ResponseEntity<?> memberList(HttpSession session){
		User user = (User) session.getAttribute("loginUser");
		int id =user.getTeam_id();
		List<User> list = myTeamManageService.searchMemberList(id);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	//멤버 팀에서 추방하기
	@PutMapping("/kickOut") 
	public ResponseEntity<?> kickOut(@RequestBody int id , HttpSession session){
		System.out.println("id" + id);
		
		//로그인한 사용자가 속한 팀이면서 로그인한 사용자가 운영자 일 때만 추방 가능
		User user = (User) session.getAttribute("loginUser");
		if(!user.getUser_team_authority().equals("운영자")) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		int result = myTeamManageService.kickOutUser(id);
		if(result !=1) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	//우리팀 정보 변경
	@PutMapping("/modify") 
	public ResponseEntity<?> modifyTeam(@RequestBody Team team , HttpSession session){
		//로그인한 사용자가 속한 팀이면서 로그인한 사용자가 운영자 일 때만 변경 가능
		System.out.println(team);
		System.out.println(team.getTeam_id());
		User user = (User) session.getAttribute("loginUser");
		System.out.println(user.getUser_team_authority());
		System.out.println(user.getTeam_id());
		if(!user.getUser_team_authority().equals("운영자") || user.getTeam_id() != team.getTeam_id()) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		int result = myTeamManageService.modifyTeam(team);
		if(result !=1) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
}
