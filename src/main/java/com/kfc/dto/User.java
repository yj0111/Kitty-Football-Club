package com.kfc.dto;

public class User {
	private int id; //회원번호
	private int team_id; //팀 ID
	private String user_id; //아이디
	private String user_kakao_id; //카카오 아이디
	private String user_naver_id; //네이버 아이디
	private String user_password; //비밀번호
	private String user_name; //이름
	private String user_phone; //핸드폰 번호
	private String user_email; //이메일
	private String user_address; //주소
	private String user_gender; //성별
	private String user_birth; //생일
	private String user_pic; //프로필 사진
	private String user_join_date; // 가입일자
	private String user_team_join_date; //팀가입일자
	
	public User() { //기본생성자

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_kakao_id() {
		return user_kakao_id;
	}

	public void setUser_kakao_id(String user_kakao_id) {
		this.user_kakao_id = user_kakao_id;
	}

	public String getUser_naver_id() {
		return user_naver_id;
	}

	public void setUser_naver_id(String user_naver_id) {
		this.user_naver_id = user_naver_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_pic() {
		return user_pic;
	}

	public void setUser_pic(String user_pic) {
		this.user_pic = user_pic;
	}

	public String getUser_join_date() {
		return user_join_date;
	}

	public void setUser_join_date(String user_join_date) {
		this.user_join_date = user_join_date;
	}

	public String getUser_team_join_date() {
		return user_team_join_date;
	}

	public void setUser_team_join_date(String user_team_join_date) {
		this.user_team_join_date = user_team_join_date;
	}

//	public User(int id, int team_id, String user_id, String user_kakao_id, String user_naver_id, String user_password,
//			String user_name, String user_phone, String user_email, String user_address, String user_gender,
//			String user_birth, String user_pic, String user_join_date, String user_team_join_date) {
//		this.id = id;
//		this.team_id = team_id;
//		this.user_id = user_id;
//		this.user_kakao_id = user_kakao_id;
//		this.user_naver_id = user_naver_id;
//		this.user_password = user_password;
//		this.user_name = user_name;
//		this.user_phone = user_phone;
//		this.user_email = user_email;
//		this.user_address = user_address;
//		this.user_gender = user_gender;
//		this.user_birth = user_birth;
//		this.user_pic = user_pic;
//		this.user_join_date = user_join_date;
//		this.user_team_join_date = user_team_join_date;
//	}

	@Override
	public String toString() {
		return "User [id=" + id + ", team_id=" + team_id + ", user_id=" + user_id + ", user_kakao_id=" + user_kakao_id
				+ ", user_naver_id=" + user_naver_id + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_phone=" + user_phone + ", user_email=" + user_email + ", user_address=" + user_address
				+ ", user_gender=" + user_gender + ", user_birth=" + user_birth + ", user_pic=" + user_pic
				+ ", user_join_date=" + user_join_date + ", user_team_join_date=" + user_team_join_date + "]";
	}
	
}
