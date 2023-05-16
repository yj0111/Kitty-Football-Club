package com.kfc.service;

import java.util.List;

import com.kfc.dto.Team;

public interface TeamService {

	int creatTeam(Team team , int id);

	List<Team> searchList(String word);

}
