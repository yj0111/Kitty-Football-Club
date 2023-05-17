package com.kfc.dao;

import com.kfc.dto.Game;
import com.kfc.dto.Gather;

public interface GameDao {
	int makeGame(Game game);

	Gather findstatus(Gather gather);
	
	int matchGame(Game game);

	int matchGame(Gather gather);
}
