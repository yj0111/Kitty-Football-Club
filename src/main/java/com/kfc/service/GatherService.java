package com.kfc.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kfc.dto.Gather;

public interface GatherService {
	int gather(Gather gather, HttpSession session);
	List<Gather> gatherList(Gather gather);
	Gather gatherOne(int gather_id);
}
