package web.socket.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.socket.server.clients.Client;
import web.socket.server.rooms.RoomService;

@RestController
@RequestMapping(path = "/create")
public class ClientRequestController {

	final RoomService service = new RoomService();

	@PostMapping(value = "/room", consumes = "application/json", produces = "application/json")
	public String getRoom(@RequestBody Client client) {
		return service.createRoom(client);
	}

	@PostMapping(value = "/connection", consumes = "application/json", produces = "application/json")
	public String getConnectingToRoom(@RequestBody Client client) {
		return service.connectToRoom(client);
	}

}
