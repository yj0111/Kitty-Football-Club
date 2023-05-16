package com.kfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.dao.TeamDetailDao;
import com.kfc.dto.Team;

@Service
public class TeamDetailServiceImpl implements TeamDetailService{
	@Autowired
	TeamDetailDao teamDetailDao;

	@Override
	public Team teamDetail(int team_id) {
		return teamDetailDao.teamDetail(team_id);
	}
}
