package com.kfc.service;

import java.util.List;

import com.kfc.dto.Team;
import com.kfc.dto.User;

public interface MyTeamManageService {

	List<User> searchMemberList(int id);

	int kickOutUser(int id);

	int modifyTeam(Team team);

}
