package com.kfc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.dao.TeamDao;
import com.kfc.dto.Team;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	TeamDao teamDao;
	@Override
	public int creatTeam(Team team, int id) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("team", team);
		paramMap.put("id", id);
		teamDao.updateUserTeam(paramMap);
		
		return teamDao.createTeam(team);
	}

}
