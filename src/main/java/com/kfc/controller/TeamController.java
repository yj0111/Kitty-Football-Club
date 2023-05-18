package com.kfc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.Game;
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
	
	//메인페이지 랭킹 가져오기
	@GetMapping("/teamrank")
	public ResponseEntity<?> teamRanking(){
		List<Team> list = teamservice.teamRanking();
		if(list == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Team>>(list, HttpStatus.OK);
	}
	
	//우리팀 랭킹, 승 패 무 가져오기
	@GetMapping("/myteamRank")
	public ResponseEntity<?> MyteamRank(HttpSession session){
		User user = (User) session.getAttribute("loginUser");
		int id = user.getTeam_id();
		List<Team> list = teamservice.MyteamRank(id);
		if(list == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Team>>(list, HttpStatus.OK);
	}
<<<<<<< HEAD
	//우리팀의 최근 경기 결고 2개 가져오기
	@GetMapping("/myteamRecord")
	public ResponseEntity<?> myteamRecord(HttpSession session){
		User user = (User) session.getAttribute("loginUser");
		int id = user.getTeam_id();
		List<Game> list = teamservice.myteamRecord(id);
		if(list == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Game>>(list, HttpStatus.OK);
	}
	
	//경기 종료 후 경기 정보 넣기 및 플레이어 골 넣기
	//먼저 내 팀 경기목록 가져오기
	@GetMapping("/myteamGameList")
	public ResponseEntity<?> myteamGameList(HttpSession session){
		User user = (User) session.getAttribute("loginUser");
		int id = user.getTeam_id();
		List<Game> list = teamservice.myteamGameList(id);
		if(list == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Game>>(list, HttpStatus.OK);
	}
	//경기 종료 후 game에 득점 수 넣고 해당 team 승 무 패  추가하고 player에 골 추가하기
	//game에 game_id , team1_id , team2_id , team1_score, team2_score
	@PutMapping("/teamRecording") 
	public ResponseEntity<?> teamRecording(@RequestBody Game game){
		//로그인한 사용자가 속한 팀이면서 로그인한 사용자가 운영자 일 때만 추방 가능
		//game테이블에 승 패 기록
		int result = teamservice.gameRecording(game);
		if(result != 1) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
=======
	
>>>>>>> 8787ccbed778609ac1bca05a959f4030e6f4e4f0
}
