package com.kfc.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.kfc.dto.Game;
import com.kfc.dto.Team;

public interface TeamService {

	int creatTeam(Team team , int id, HttpSession session);

	List<Team> searchList(String word);

	HashMap<String, List<Team>> teamRanking();
	
	Team MyteamRank(int id); // 우리팀 랭킹, 승 패 무 


	List<Game> myteamGameList(int id);

	int gameRecording(Game game);

	List<Game> myteamRecord(int id);



}
