package web.socket.server.rooms;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import web.socket.server.clients.Client;
import web.socket.server.rooms.repository.FirstRoom;
import web.socket.server.rooms.repository.SecondRoom;

@Service
public class RoomService {

	private ArrayList<Room> rooms = new ArrayList<>();
	{
		rooms.add(
				Room.builder().id(1).name("firstRoom").status("free").actualRoom(FirstRoom.builder().build()).build());
		rooms.add(Room.builder().id(2).name("secondRoom").status("busy").actualRoom(SecondRoom.builder().build())
				.build());
	}

	public Boolean checkFreeRoomAndConnect(Client client) {

		if (rooms.get(client.getExpectedRoom()).getStatus().equals("free")) {

			rooms.get(client.getExpectedRoom()).setClients(client);
			rooms.get(client.getExpectedRoom()).setStatus("waitingFor");
			return true;

		} else if (rooms.get(client.getExpectedRoom()).getStatus().equals("waitingFor")) {

			return rooms.get(client.getExpectedRoom()).isWaitingMatch(client) ? true : false;

		} else
			return false;

	}
}
