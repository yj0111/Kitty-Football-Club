package com.kfc.dao;

import java.util.Map;

import com.kfc.dto.Team;

public interface TeamDao {

	int createTeam(Team team);

	Team selectTeamInfo();

	int UserUpdate(int team_id, String team_birth, int id);

	

}
