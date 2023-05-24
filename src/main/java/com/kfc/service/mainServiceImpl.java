package com.kfc.service;

import java.util.HashMap;
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
	public HashMap<String, List<Game>> gameList() {
		HashMap<String, List<Game>> map = new HashMap<String, List<Game>>();
		List<Game> today = mainDao.gameToday();
		List<Game> tommo= mainDao.gameTommo();
		List<Game> sand = mainDao.gameSand();
		map.put("today", today);
		map.put("tommo", tommo);
		map.put("sand", sand);
		
		
		
		return map;
	}

	@Override
	public Game searchRecordOne() {
		return mainDao.searchRecordOne();
	}
}
