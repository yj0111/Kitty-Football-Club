package com.kfc.dto;

public class Team { 
	private int team_id; //팀 ID
	private String team_name; //팀 이름
	private String team_logo; //팀 로고
	private String team_content; //팀 설명 
	private String team_announcement; //팀 공고
	private String team_birth; //팀 개설일 
	private String team_status; //팀 상태
	
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
			String team_birth, String team_status) {
		this.team_id = team_id;
		this.team_name = team_name;
		this.team_logo = team_logo;
		this.team_content = team_content;
		this.team_announcement = team_announcement;
		this.team_birth = team_birth;
		this.team_status = team_status;
	}

	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", team_name=" + team_name + ", team_logo=" + team_logo + ", team_content="
				+ team_content + ", team_announcement=" + team_announcement + ", team_birth=" + team_birth
				+ ", team_status=" + team_status + "]";
	}
	
	
}
