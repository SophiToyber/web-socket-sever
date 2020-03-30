package web.socket.server.rooms;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import web.socket.server.clients.Client;

@Service
public class RoomService {

	private final String WAITING_FOR = "waitingFor";
	private final String EMPTY = "empty";

	private ArrayList<Room> rooms = new ArrayList<Room>();

	public String createRoom(Client client) {
		Integer roomSize = rooms.size();
		try {
			rooms.add(Room.builder().id(++roomSize).name(client.getTopic()).status(WAITING_FOR).build());
			rooms.get(roomSize).setClients(client);
			return "created";
		} catch (Exception e) {
			return String.format("Error creating:: %s", e.getMessage());
		}

	}

	public String connectToRoom(Client client) {
		//find room
		Optional<Room> optionalRoom = rooms.stream().filter(room -> room.getName().equals(client.getExpectedRoom()))
				.findAny();
		// add Client to RoomClients list
		optionalRoom.get().setClients(client);
		//return topic to user
		return optionalRoom.isPresent() ? optionalRoom.get().getName() : EMPTY;
	}

}
