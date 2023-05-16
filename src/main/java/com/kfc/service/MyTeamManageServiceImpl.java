package com.kfc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.dao.TeamManageDao;
import com.kfc.dto.User;
@Service
public class MyTeamManageServiceImpl implements MyTeamManageService {
	@Autowired
	TeamManageDao teamManageDao;
	@Override
	public List<User> searchMemberList(int id) {
		return teamManageDao.searchMemberList(id);
	}
	@Override
	public int kickOutUser(int id) {
		return teamManageDao.kickOutUser(id);
	}

}
