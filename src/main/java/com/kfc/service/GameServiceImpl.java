package com.kfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.dao.GameDao;
import com.kfc.dto.Game;
import com.kfc.dto.Gather;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	GameDao gameDao;

	@Override
	public int makeGame(Game game) {
		return gameDao.makeGame(game);
	}
	
	@Override
	public Gather findstatus(Gather gather) {
		
		return gameDao.findstatus(gather);
	}

	@Override
	public int matchGame(Gather gather) {
		return  gameDao.matchGame( gather);
	}

}
