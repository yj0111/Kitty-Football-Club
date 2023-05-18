package com.kfc.dao;

import java.util.List;

import com.kfc.dto.Gather;

public interface GatherDao {
	int gather(Gather gather);
	
	List<Gather> gatherList(Gather gather);
	
	Gather gatherOne(int gather_id);
	
	int selectGatherInfo();
}
