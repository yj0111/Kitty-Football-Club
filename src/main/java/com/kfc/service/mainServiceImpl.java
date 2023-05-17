package com.kfc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.dao.MainDao;
import com.kfc.dto.Game;

@Service
public class mainServiceImpl implements MainService {
	@Autowired
	MainDao mainDao;

	@Override
	public List<Game> searchRecord() {
		return mainDao.searchRecord();
	}

	@Override
	public List<Game> gameList() {
		return mainDao.gameList();
	}
}
