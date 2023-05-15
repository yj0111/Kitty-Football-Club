package com.kfc.dao;

import java.util.Map;

import com.kfc.dto.Team;

public interface TeamDao {

	int createTeam(Team team);

	void updateUserTeam(Map<String, Object> paramMap);

}
