package com.kfc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfc.dao.TeamDao;
import com.kfc.dto.Game;
import com.kfc.dto.Team;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	TeamDao teamDao;

	@Override
	public int creatTeam(Team team, int id) {
		int result = teamDao.createTeam(team);
		int userResult = 0;
		if (result == 1) {
			Team tm = teamDao.selectTeamInfo();
			userResult = teamDao.UserUpdate(tm.getTeam_id(), tm.getTeam_birth(), id);
		} else {
			return 0;
		}
		return userResult;
	}

	@Override
	public List<Team> searchList(String word) {
		return teamDao.searchList(word);
	}

	@Override
	public List<Team> teamRanking() {
		return teamDao.teamRanking();
	}
	
	@Override
	public Team MyteamRank(int id) {
		return teamDao.MyteamRank(id);
	}


	@Override
	public List<Game> myteamGameList(int id) {
		return teamDao.myteamGameList(id);
	}
	
	@Transactional
	@Override
	public int gameRecording(Game game) {
		int result = teamDao.gameRecording(game);
		
		int teamScore1 = game.getTeam1_score();
		int teamScore2 = game.getTeam2_score();
		int team1 =0;
		if(result ==1) {
			if(teamScore1 > teamScore2) {
				team1 = 1; //승
			}else if(teamScore1 == teamScore2) {
				team1 = 2;//무
			}else {
				team1 = 3; //패
			}
			//각 팀에 승 무 패 추가시키기
			int team1_id = game.getTeam1_id();
			int team2_id = game.getTeam2_id();
			int a =teamDao.teamRecording1(team1_id, team1);
			int b =teamDao.teamRecording2(team2_id, team1);
			System.out.println("team1_id" + team1_id);
			System.out.println("team " +team1);
			System.out.println("a " + a);
			System.out.println("b" + b);
		}
		return result;
	}

	@Override
	public List<Game> myteamRecord(int id) {
		return teamDao.myteamRecord(id);
	}

}
