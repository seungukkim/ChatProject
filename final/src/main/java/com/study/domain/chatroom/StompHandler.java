package com.study.domain.chatroom;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Component

public class StompHandler implements ChannelInterceptor{
	
	
	/*
	 * private HashMap<String, Integer> count=new HashMap<String,Integer>(); public
	 * HashMap<String, Integer> hello = new HashMap<String,Integer>();
	 */

	
	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		StompCommand command = accessor.getCommand();
		System.out.println("핸들러의 preSend 호출됨");
		
		String destination = accessor.getDestination();
		
		
		if(command.compareTo(StompCommand.SUBSCRIBE) == 0) {
			//websocket 연결 요청
			//Chatservice상에서 1을 추가하는 행위를 한번 해보자 
			String[] array = destination.split("/");
			for(int i=0;i<array.length;i++) {
				System.out.println(array[i]);
			}
			
			
			
			System.out.println("구독 주소: "+destination);
			System.out.println(message);		

		}
		else if(command.compareTo(StompCommand.CONNECT) == 0) {
			//이게 제일 처음으로 실행됨.
			//연결 => 구독 => 해제의 순서라고 생각
			System.out.println("사용자 연결");

		}
		else if(command.compareTo(StompCommand.DISCONNECT) == 0) {

			
			System.out.println("사용자 연결 해제");
		}
		else {
			System.out.println("핸들러의 else");
			
		}
		System.out.println("리턴할 메세지의 페이로드 : ");
		System.out.println(message.getPayload());
		return message;
	}

}
