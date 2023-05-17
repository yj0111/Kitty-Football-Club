package com.kfc.dao;

import com.kfc.dto.Player;

public interface PlayerDao {
	int applyGame(Player player);
	
	int playerCnt(int gather_id);
	
}
