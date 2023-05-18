package com.kfc.dao;

import java.util.List;

import com.kfc.dto.Team;

public interface TeamDao {

	int createTeam(Team team);

	Team selectTeamInfo();

	int UserUpdate(int team_id, String team_birth, int id);

	List<Team> searchList(String word);

	List<Team> teamRanking();

	List<Team> MyteamRank(int id); // 우리팀 랭킹, 승 패 무 
	
}
