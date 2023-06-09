package com.kfc.dto;

public class Chat {
    // 유저의 이름을 저장하기 위한 변수
    private String userName;

    // 메시지의 내용을 저장하기 위한 변수
    private String content;
    
    private String user_pic;


	public String getUser_pic() {
		return user_pic;
	}

	public void setUser_pic(String user_pic) {
		this.user_pic = user_pic;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public Chat(String userName, String content, String user_pic) {
		super();
		this.userName = userName;
		this.content = content;
		this.user_pic = user_pic;
	}

	public Chat() {
		super();
	}
    
    
}
