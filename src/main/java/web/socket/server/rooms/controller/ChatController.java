package web.socket.server.rooms.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import web.socket.server.message.Message;
import web.socket.server.message.OutputMessage;

@Controller
public class ChatController {

	@MessageMapping("/chat/{topic}")
	@SendTo("/topic/messages")
	public OutputMessage send(@DestinationVariable("topic") String topic, Message message) throws Exception {
		return new OutputMessage(message.getFrom(), message.getText(), topic);
	}

}