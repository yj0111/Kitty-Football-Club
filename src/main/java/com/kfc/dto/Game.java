package com.kfc.dto;

public class Game {
	private int game_id; //경기 아이디
	private int game_team1; //팀1 
	private int game_team2; //팀2
	private int team1_score; //팀1 점수
	private int team2_score; //팀2 점수 
	
	public Game() {
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public int getGame_team1() {
		return game_team1;
	}

	public void setGame_team1(int game_team1) {
		this.game_team1 = game_team1;
	}

	public int getGame_team2() {
		return game_team2;
	}

	public void setGame_team2(int game_team2) {
		this.game_team2 = game_team2;
	}

	public int getTeam1_score() {
		return team1_score;
	}

	public void setTeam1_score(int team1_score) {
		this.team1_score = team1_score;
	}

	public int getTeam2_score() {
		return team2_score;
	}

	public void setTeam2_score(int team2_score) {
		this.team2_score = team2_score;
	}

	public Game(int game_id, int game_team1, int game_team2, int team1_score, int team2_score) {
		this.game_id = game_id;
		this.game_team1 = game_team1;
		this.game_team2 = game_team2;
		this.team1_score = team1_score;
		this.team2_score = team2_score;
	}

	@Override
	public String toString() {
		return "Game [game_id=" + game_id + ", game_team1=" + game_team1 + ", game_team2=" + game_team2
				+ ", team1_score=" + team1_score + ", team2_score=" + team2_score + "]";
	}
	
	
}
