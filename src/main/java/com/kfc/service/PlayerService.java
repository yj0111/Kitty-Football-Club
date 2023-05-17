package com.kfc.service;

import com.kfc.dto.Player;

public interface PlayerService {

	int applyGame(Player player);
	
	int playerCnt(int gather_id);

}
