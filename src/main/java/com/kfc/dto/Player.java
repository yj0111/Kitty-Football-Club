package com.kfc.dto;

public class Player {
	private int gather_id; // 경기모집 아이디
	private int id; //회원 아이디
	private int player_goal; // 골
	
	public Player() {
	}

	public int getGather_id() {
		return gather_id;
	}

	public void setGather_id(int gather_id) {
		this.gather_id = gather_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlayer_goal() {
		return player_goal;
	}

	public void setPlayer_goal(int player_goal) {
		this.player_goal = player_goal;
	}

	public Player(int gather_id, int id, int player_goal) {
		this.gather_id = gather_id;
		this.id = id;
		this.player_goal = player_goal;
	}

	@Override
	public String toString() {
		return "Player [gather_id=" + gather_id + ", id=" + id + ", player_goal=" + player_goal + "]";
	}

	
}
