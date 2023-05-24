package com.kfc.dao;

import java.util.List;

import com.kfc.dto.Game;
import com.kfc.dto.Team;

public interface TeamDao {

	int createTeam(Team team);

	Team selectTeamInfo();

	int UserUpdate(int team_id, String team_birth, int id);

	List<Team> searchList(String word);

	List<Team> teamRanking1();

	Team MyteamRank(int id); // 우리팀 랭킹, 승 패 무 


	List<Game> myteamGameList(int id);

	int gameRecording(Game game);

	int teamRecording1(int team1_id, int team1);

	int teamRecording2(int team2_id, int team1);

	List<Game> myteamRecord(int id);

	List<Team> teamRanking2();

	Team getTeam();

}
