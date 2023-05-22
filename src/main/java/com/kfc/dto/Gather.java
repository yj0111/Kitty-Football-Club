package com.kfc.dto;

public class Gather {
	private int gather_id; // 모집 아이디
	private int stadium_id; // 경기장 아이디
	private int team_id; // 팀 아이디
	private String gather_date; // 모집 날짜
	private String gather_announcement; // 모집 글
	
	
	private int player_cnt;// 모인 사람 수
	private int game_id; //쿼리를 위해서........ 
	private String stadium_img;
	private String stadium_name;
	private String stadium_address;
	private String stadium_price;
	
	public String getStadium_price() {
		return stadium_price;
	}

	public void setStadium_price(String stadium_price) {
		this.stadium_price = stadium_price;
	}

	public String getStadium_img() {
		return stadium_img;
	}

	public void setStadium_img(String stadium_img) {
		this.stadium_img = stadium_img;
	}

	public String getStadium_name() {
		return stadium_name;
	}

	public void setStadium_name(String stadium_name) {
		this.stadium_name = stadium_name;
	}

	public String getStadium_address() {
		return stadium_address;
	}

	public void setStadium_address(String stadium_address) {
		this.stadium_address = stadium_address;
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public Gather() {
	}

	public int getPlayer_cnt() {
		return player_cnt;
	}

	public void setPlayer_cnt(int player_cnt) {
		this.player_cnt = player_cnt;
	}

	public String getGather_announcement() {
		return gather_announcement;
	}

	public void setGather_announcement(String gather_announcement) {
		this.gather_announcement = gather_announcement;
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

	public Gather(int gather_id, int stadium_id, int team_id, String gather_date, String gather_announcement,
			int player_cnt) {
		super();
		this.gather_id = gather_id;
		this.stadium_id = stadium_id;
		this.team_id = team_id;
		this.gather_date = gather_date;
		this.gather_announcement = gather_announcement;
		this.player_cnt = player_cnt;
	}

	@Override
	public String toString() {
		return "Gather [gather_id=" + gather_id + ", stadium_id=" + stadium_id + ", team_id=" + team_id
				+ ", gather_date=" + gather_date + ", gather_announcement=" + gather_announcement + ", player_cnt="
				+ player_cnt + "]";
	}

}
