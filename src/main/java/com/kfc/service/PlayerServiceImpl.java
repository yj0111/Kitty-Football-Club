package com.kfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.dao.PlayerDao;
import com.kfc.dto.Player;

@Service
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	PlayerDao playerDao;

	@Override
	public int applyGame(Player player) {
		return playerDao.applyGame(player);
	}

	@Override
	public int playerCnt(int gather_id) {
		return playerDao.playerCnt(gather_id);
	}



}
