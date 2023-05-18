package com.kfc.service;

import java.util.List;

import com.kfc.dto.Game;
import com.kfc.dto.Team;

public interface TeamService {

	int creatTeam(Team team , int id);

	List<Team> searchList(String word);

	List<Team> teamRanking();
	
	List<Team> MyteamRank(int id); // 우리팀 랭킹, 승 패 무 

<<<<<<< HEAD
	List<Game> myteamGameList(int id);

	int gameRecording(Game game);

	List<Game> myteamRecord(int id);
=======
>>>>>>> 8787ccbed778609ac1bca05a959f4030e6f4e4f0
}
