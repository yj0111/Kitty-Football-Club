package com.kfc.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.dao.GatherDao;
import com.kfc.dao.PlayerDao;
import com.kfc.dto.Gather;
import com.kfc.dto.Player;
import com.kfc.dto.User;

@Service
public class GatherServiceImpl implements GatherService {

	@Autowired
	GatherDao gatherDao;

	@Autowired
	PlayerDao playerDao;

	@Override
	public int gather(Gather gather, HttpSession session) {
		User user = (User) session.getAttribute("loginUser");

		int result = gatherDao.gather(gather);
		int GatherResult = 0;
		int playerResult = 0;
		if (result == 1) {
			GatherResult = gatherDao.selectGatherInfo(); // 마지막으로 만든 경기 번호
			Player player = new Player();
			player.setGather_id(GatherResult);
			player.setId(user.getId());
			playerResult = playerDao.applyGame(player);
		} else {
			return 0;
		}
		return playerResult;
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
