package com.kfc.service;

import java.util.List;

import com.kfc.dto.Gather;

public interface GatherService {
	int gather(Gather gather);
	List<Gather> gatherList(Gather gather);
	Gather gatherOne(int gather_id);
}
