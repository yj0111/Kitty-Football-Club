package com.kfc.dto;

public class Gather {
	private int gather_id; //모집 아이디
	private int stadium_id; //경기장 아이디
	private int team_id; //팀 아이디
	private String gather_date; //모집 날짜
	
	public Gather() {
	}

	public int getGather_id() {
		return gather_id;
	}

	public void setGather_id(int gather_id) {
		this.gather_id = gather_id;
	}

	public int getStadium_id() {
		return stadium_id;
	}

	public void setStadium_id(int stadium_id) {
		this.stadium_id = stadium_id;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getGather_date() {
		return gather_date;
	}

	public void setGather_date(String gather_date) {
		this.gather_date = gather_date;
	}

	public Gather(int gather_id, int stadium_id, int team_id, String gather_date) {
		this.gather_id = gather_id;
		this.stadium_id = stadium_id;
		this.team_id = team_id;
		this.gather_date = gather_date;
	}

	@Override
	public String toString() {
		return "Gather [gather_id=" + gather_id + ", stadium_id=" + stadium_id + ", team_id=" + team_id
				+ ", gather_date=" + gather_date + "]";
	}
	
	
}
