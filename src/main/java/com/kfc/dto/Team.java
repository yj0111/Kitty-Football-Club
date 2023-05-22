package com.kfc.dto;

public class Team { 
	private int team_id; //팀 ID
	private String team_name; //팀 이름
	private String team_logo; //팀 로고
	private String team_content; //팀 설명 
	private String team_announcement; //팀 공고
	private String team_birth; //팀 개설일 
	private String team_status; //팀 상태
	private int team_win; //팀 승리 횟수
	private int team_lose;//팀 진 횟수
	private int team_draw;//팀 무승부 횟수
	
	private String user_name; //대표 이름
	private int total_cnt; //팀원수 
	private int ranking; // 등수
	private int score; // 등수
	
	private int id;
	
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getTotal_cnt() {
		return total_cnt;
	}

	public void setTotal_cnt(int total_cnt) {
		this.total_cnt = total_cnt;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getTeam_win() {
		return team_win;
	}

	public void setTeam_win(int team_win) {
		this.team_win = team_win;
	}

	public int getTeam_lose() {
		return team_lose;
	}

	public void setTeam_lose(int team_lose) {
		this.team_lose = team_lose;
	}

	public int getTeam_draw() {
		return team_draw;
	}

	public void setTeam_draw(int team_draw) {
		this.team_draw = team_draw;
	}

	public Team() {
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getTeam_logo() {
		return team_logo;
	}

	public void setTeam_logo(String team_logo) {
		this.team_logo = team_logo;
	}

	public String getTeam_content() {
		return team_content;
	}

	public void setTeam_content(String team_content) {
		this.team_content = team_content;
	}

	public String getTeam_announcement() {
		return team_announcement;
	}

	public void setTeam_announcement(String team_announcement) {
		this.team_announcement = team_announcement;
	}

	public String getTeam_birth() {
		return team_birth;
	}

	public void setTeam_birth(String team_birth) {
		this.team_birth = team_birth;
	}

	public String getTeam_status() {
		return team_status;
	}

	public void setTeam_status(String team_status) {
		this.team_status = team_status;
	}

	public Team(int team_id, String team_name, String team_logo, String team_content, String team_announcement,
			String team_birth, String team_status, int team_win, int team_lose, int team_draw, String user_name,
			int total_cnt, int ranking) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
		this.team_logo = team_logo;
		this.team_content = team_content;
		this.team_announcement = team_announcement;
		this.team_birth = team_birth;
		this.team_status = team_status;
		this.team_win = team_win;
		this.team_lose = team_lose;
		this.team_draw = team_draw;
		this.user_name = user_name;
		this.total_cnt = total_cnt;
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", team_name=" + team_name + ", team_logo=" + team_logo + ", team_content="
				+ team_content + ", team_announcement=" + team_announcement + ", team_birth=" + team_birth
				+ ", team_status=" + team_status + ", team_win=" + team_win + ", team_lose=" + team_lose
				+ ", team_draw=" + team_draw + ", user_name=" + user_name + ", total_cnt=" + total_cnt + ", ranking="
				+ ranking + "]";
	}

	
}
