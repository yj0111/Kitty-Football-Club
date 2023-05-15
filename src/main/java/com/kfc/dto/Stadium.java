package com.kfc.dto;

public class Stadium {
	private int stadium_id;  //경기장 ID
	private String stadium_name; //경기장 이름
	private String stadium_address; //경기장 주소
	private String stadium_img; //경기장 이미지
	private int stadium_price; //경기장 가격

	public Stadium() {
	}

	public int getStadium_id() {
		return stadium_id;
	}

	public void setStadium_id(int stadium_id) {
		this.stadium_id = stadium_id;
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

	public String getStadium_img() {
		return stadium_img;
	}

	public void setStadium_img(String stadium_img) {
		this.stadium_img = stadium_img;
	}

	public int getStadium_price() {
		return stadium_price;
	}

	public void setStadium_price(int stadium_price) {
		this.stadium_price = stadium_price;
	}

	public Stadium(int stadium_id, String stadium_name, String stadium_address, String stadium_img, int stadium_price) {
		this.stadium_id = stadium_id;
		this.stadium_name = stadium_name;
		this.stadium_address = stadium_address;
		this.stadium_img = stadium_img;
		this.stadium_price = stadium_price;
	}

	@Override
	public String toString() {
		return "Stadium [stadium_id=" + stadium_id + ", stadium_name=" + stadium_name + ", stadium_address="
				+ stadium_address + ", stadium_img=" + stadium_img + ", stadium_price=" + stadium_price + "]";
	}

}
