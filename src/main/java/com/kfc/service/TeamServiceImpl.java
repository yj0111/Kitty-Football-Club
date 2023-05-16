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
		int result = teamDao.createTeam(team);
		int userResult = 0;
		if(result == 1) {
			Team tm = teamDao.selectTeamInfo();
			userResult = teamDao.UserUpdate(tm.getTeam_id(), tm.getTeam_birth(), id);
		}else {
			return 0;
		}
		
	
		
		return userResult;
	}

}
