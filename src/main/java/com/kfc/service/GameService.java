package com.kfc.service;

import com.kfc.dto.Game;
import com.kfc.dto.Gather;

public interface GameService {
	int makeGame(Game game);
	
	Gather findstatus(Gather gather);

	int matchGame(Gather gather);
}
