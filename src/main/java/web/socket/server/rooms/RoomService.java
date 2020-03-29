package web.socket.server.rooms;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import web.socket.server.clients.Client;
import web.socket.server.rooms.repository.RoomTemplate;

@Service
public class RoomService {

	private final String WAITING_FOR = "waitingFor";
	private ArrayList<Room> rooms = new ArrayList<>();
	{
		rooms.add(Room.builder().id(1).name("firstRoom").status("free").build());
	}

	public Boolean checkFreeRoomAndConnect(Client client) {

		if (rooms.get(client.getExpectedRoom()).getStatus().equals("free")) {

			rooms.get(client.getExpectedRoom()).setClient(client);
			rooms.get(client.getExpectedRoom()).setStatus(WAITING_FOR);
			return true;

		} else if (rooms.get(client.getExpectedRoom()).getStatus().equals(WAITING_FOR)) {
			return rooms.get(client.getExpectedRoom()).isWaitingMatch(client) ? true : false;

		} else
			return false;

	}
}
