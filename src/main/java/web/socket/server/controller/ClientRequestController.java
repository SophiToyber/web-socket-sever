package web.socket.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.socket.server.clients.Client;
import web.socket.server.rooms.RoomService;

@RestController
@RequestMapping(path = "/create")
public class ClientRequestController {
	
	RoomService service;
	
	@GetMapping("/room")
	public String getRoom(@RequestBody Client client) {
		return service.createRoom(client);
	}
	
	@GetMapping("/connection")
	public String getConnectingToRoom(@RequestBody Client client) {
		return service.connectToRoom(client);
	}

}
