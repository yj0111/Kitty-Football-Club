package com.kfc.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.kfc.dto.Chat;

@Controller
public class SocketHandler {
	// /receive를 메시지를 받을 endpoint로 설정합니다.
    @MessageMapping("/receive")
    
    // /send로 메시지를 반환합니다.
    @SendTo("/send")
    
    // SocketHandler는 1) /receive에서 메시지를 받고, /send로 메시지를 보내줍니다.
    // 정의한 SocketVO를 1) 인자값, 2) 반환값으로 사용합니다.
    public Chat SocketHandler(Chat socketVO) {
        // vo에서 getter로 userName을 가져옵니다.
        String userName = socketVO.getUserName();
        // vo에서 setter로 content를 가져옵니다.
        String content = socketVO.getContent();
        System.out.println("내용이다 "+ content);
        System.out.println("사진이다"+socketVO.getUser_pic());
        String user_pic = socketVO.getUser_pic();
        

        // 생성자로 반환값을 생성합니다.
        Chat result = new Chat(userName, content, user_pic);
        // 반환
        return result;
    }
}
