package web.socket.server.rooms.repository;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@Controller
public class SecondRoom {

	@MessageMapping("/secondRoom")
	@SendTo("/queue/secondApp")
	public String sendOrGetMessage(String message) throws Exception {

		// After create Client this metod will be config for sending message

		log.info("Server GET message --" + message);
		return message;
	}

}
