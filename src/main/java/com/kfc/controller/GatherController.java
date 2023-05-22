package com.kfc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.Gather;
import com.kfc.dto.User;
import com.kfc.service.GatherService;
import com.kfc.service.PlayerService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/gather")
@Api(tags = "게임 모집 컨트롤러")
public class GatherController {

	@Autowired
	GatherService gatherService;

	@Autowired
	PlayerService playerService;
	
	   public static String getBody(HttpServletRequest request) throws IOException {
		   
	        String body = null;
	        StringBuilder stringBuilder = new StringBuilder();
	        BufferedReader bufferedReader = null;
	 
	        try {
	            InputStream inputStream = request.getInputStream();
	            if (inputStream != null) {
	                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	                char[] charBuffer = new char[128];
	                int bytesRead = -1;
	                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                    stringBuilder.append(charBuffer, 0, bytesRead);
	                }
	            }
	        } catch (IOException ex) {
	            throw ex;
	        } finally {
	            if (bufferedReader != null) {
	                try {
	                    bufferedReader.close();
	                } catch (IOException ex) {
	                    throw ex;
	                }
	            }
	        }
	 
	        body = stringBuilder.toString();
	        return body;
	    }
	// 모집 공고 만들기
	@PostMapping("/make")
	public ResponseEntity<Integer> gather(@RequestBody Gather gather, HttpSession session) throws IOException {
		User user = (User) session.getAttribute("loginUser");
		System.out.println(user);
		int team_id = user.getTeam_id();
		System.out.println("팀 아이디 "+team_id);
		gather.setTeam_id(team_id);
		int result = gatherService.gather(gather,session);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// 우리팀 모집 공고 리스트
	@GetMapping("/gatherList")
	public ResponseEntity<?> gatherList(@RequestParam String year, @RequestParam String month, @RequestParam String date, HttpSession session) {
		System.out.println("여기오냐???");
		System.out.println(year + "//"+month);
		System.out.println(session.getAttribute("loginUser"));
		User user = (User) session.getAttribute("loginUser");
		int team_id = user.getTeam_id();
		System.out.println("내정보 " + user.toString());
		System.out.println("팀 아이디는 :" + team_id);

		Gather gather= new Gather();
		gather.setTeam_id(team_id);
		String setdate = year+"-"+month+"-"+date;
		gather.setGather_date(setdate);

		List<Gather> gatherList = gatherService.gatherList(gather);
		System.out.println(gatherList);
		System.out.println("gather"+gather);
		if (gatherList == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Gather>>(gatherList, HttpStatus.OK);
	}

	// 공고 하나씩 조회
	@GetMapping("/gatherList/{gather_id}")
	public ResponseEntity<Gather> gatherList(@PathVariable int gather_id) {
		Gather gather = gatherService.gatherOne(gather_id);
		System.out.println(gather);
		if (gather == null) {
			return new ResponseEntity<Gather>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Gather>(gather, HttpStatus.OK);
	}

}
