package com.study.domain.chatroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {

	
	private Map<String, ChatRoomDto> chatRooms;

    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    //채팅방 불러오기
    public List<ChatRoomDto> findAllRoom() {
        //채팅방 최근 생성 순으로 반환
        List<ChatRoomDto> result = new ArrayList<>(chatRooms.values());
        
        Collections.reverse(result);

        return result;
    }

    //채팅방 하나 불러오기
    public ChatRoomDto findById(String roomId) {
        return chatRooms.get(roomId);
    }

    //채팅방 생성
    public ChatRoomDto createRoom(String name,String maker) {
        ChatRoomDto chatRoom = ChatRoomDto.create(name,maker);
        
        chatRooms.put(chatRoom.getRoomId(), chatRoom); // 이 부분에서 보면 chatRoom.getRoomId()를 쓰고 있다.
        return chatRoom;
    }
    //채팅방 전체 삭제(테스트용)
    public void deleteRoom() {
    	chatRooms.clear();
    }
    
    //채팅방 삭제 제대로
    public void deleteRoom1(String name) {
    	chatRooms.remove(name);
    	
    }
    
    //들어왔을 때 인원수를 증가시키는 서비스
    public void plusPeople(String roomId) {
     	int participants= chatRooms.get(roomId).getParticipant();
     	participants+=1;
     	chatRooms.get(roomId).setParticipant(participants);     	
    }
    
    //나갈 때 인원수를 감소시키는 서비스
    public void minusPeople(String roomId) {
    	int participants = chatRooms.get(roomId).getParticipant();
    	participants-=1;
    	chatRooms.get(roomId).setParticipant(participants);
    }
}
