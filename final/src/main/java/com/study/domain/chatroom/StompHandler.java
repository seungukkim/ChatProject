package com.study.domain.chatroom;

import java.util.HashMap;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import groovy.util.logging.Slf4j;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Slf4j
@RequiredArgsConstructor
@Component
@Getter
@Setter
public class StompHandler implements ChannelInterceptor{
	private HashMap<String, Integer> count=new HashMap<String,Integer>();
	public HashMap<String, Integer> hello = new HashMap<String,Integer>();
	public Integer test=0;
	private String commonString;
	
	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		StompCommand command = accessor.getCommand();
		System.out.println("핸들러의 preSend 호출됨");
		
		String destination = accessor.getDestination();

		
		if(command.compareTo(StompCommand.SUBSCRIBE) == 0) {
			//websocket 연결 요청
						
			if(count.get(destination)==null) {
				System.out.println("데스티네이션이 null임");
				//처음 만들어진 방이라면 인원수에 1을 넣는다.
				count.put(destination, 1);
				hello.put("hello", 10); // 실험용도
				test=100;
			}
			else {
				System.out.println("데스티네이션이 null이 아님");
				//그렇지 않다면 현재 인원수 값을 구하고 1을 더한다.
				int a= count.get(destination)+1;
				System.out.println("최초의 방이 아님.  현재 바꿀인원수 : "+a);
				count.replace(destination, a);
			}
			System.out.println("현재 인원수는:"+count.get(destination));
			System.out.println("구독 주소: "+destination);
			System.out.println(message);		
			System.out.println("test용도 :"+hello.get("hello")); //10이 제대로 들어갔음을 확인할 수 있다.
		}
		else if(command.compareTo(StompCommand.CONNECT) == 0) {
			//이게 제일 처음으로 실행됨.
			//연결 => 구독 => 해제의 순서라고 생각
			System.out.println("사용자 연결");

		}
		else if(command.compareTo(StompCommand.DISCONNECT) == 0) {
			int a= count.get(destination)-1;
			count.replace(destination, a);
			
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
