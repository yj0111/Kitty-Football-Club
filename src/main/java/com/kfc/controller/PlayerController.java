package com.kfc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.Game;
import com.kfc.dto.Gather;
import com.kfc.dto.Player;
import com.kfc.dto.User;
import com.kfc.service.GameService;
import com.kfc.service.GatherService;
import com.kfc.service.PlayerService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/player")
@Api(tags = "경기 신청 컨트롤러")
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@Autowired
	GameService gameService;

	@Autowired
	GatherService gatherService;
	
	@PostMapping("/applyGame/{gather_id}")
	public ResponseEntity<Integer> applyGame(@PathVariable int gather_id, HttpSession session) {
	
		User user = (User) session.getAttribute("loginUser");
		System.out.println("user" + user);
		int id = user.getId(); // 회원 아이디
		Player player = new Player();
		player.setId(id);
		player.setGather_id(gather_id);
			System.out.println(id+"번 회원이 "+ gather_id +"번 모집공고에 신청");
		
		int result = playerService.applyGame(player);
		int playerCnt = playerService.playerCnt(gather_id); //몇명이 신청했는지 
		
		System.out.println("현재 인원 : "+ playerCnt); //이사람이 신청 한 뒤 몇명인지?
		
		if(playerCnt == 11) {
			Gather gather = gatherService.gatherOne(gather_id);
			//경기장, 날짜 같은애 가져오기
			
			int answer= 0;
			Gather status = gameService.findstatus(gather);
			System.out.println(status);
			if(status == null) {
				System.out.println("qwqwqwqwqw");
				Game game = new Game();
				 game.setGame_team1(gather.getGather_id());
				 game.setGame_date(gather.getGather_date());
				 gameService.makeGame(game);				
			}else {
				System.out.println("eweweweee");
				gather.setGame_id(status.getGame_id());
				answer =  gameService.matchGame(gather);
			}
		}
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	 
}
