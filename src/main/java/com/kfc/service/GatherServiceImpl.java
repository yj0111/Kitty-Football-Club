package com.kfc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.dao.GatherDao;
import com.kfc.dto.Gather;

@Service
public class GatherServiceImpl implements GatherService{

	@Autowired
	GatherDao gatherDao;

	@Override
	public int gather(Gather gather) {
		return gatherDao.gather(gather);
	}

	@Override
	public List<Gather> gatherList(Gather gather) {
		return gatherDao.gatherList(gather);
	}

	@Override
	public Gather gatherOne(int gather_id) {
		return gatherDao.gatherOne(gather_id);
	}

}
