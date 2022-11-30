package com.study.domain.chatroom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoomDto {
	 private String roomId;
	 private String roomName;
	 private Integer chatnum;
	 private String createdDate; 
	 private String roomMaker;
	 private Integer participant;
	 
	

	    public static ChatRoomDto create(String name,String maker) {
	        ChatRoomDto room = new ChatRoomDto();
	        room.roomId = UUID.randomUUID().toString();
	        room.roomName = name;
	        room.roomMaker= maker; // 방 생성자
	   
	        LocalDateTime now=LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatDateTime = now.format(formatter);	        
	        room.createdDate=formatDateTime;	        
	        room.participant=0; // 방을 만드는 시점에서는 참여자를 0으로 한다.
	        
	        
	        
	        return room;
	    }

}
