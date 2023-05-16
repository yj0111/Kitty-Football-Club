package com.kfc.dao;

import java.util.List;

import com.kfc.dto.User;

public interface TeamManageDao {

	List<User> searchMemberList(int id);

	int kickOutUser(int id);

}
