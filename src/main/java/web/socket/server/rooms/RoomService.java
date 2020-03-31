package web.socket.server.rooms;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import web.socket.server.clients.Client;

@Service
public class RoomService {

	private final String WAITING_FOR = "waitingFor";
	private final String EMPTY = "empty";
	private final String CREATED = "created";
	private ArrayList<Room> rooms = new ArrayList<Room>();

	public String createRoom(Client client) {
		Integer roomSize = rooms.size();
		try {
			rooms.add(Room.builder().id(0).name(client.getTopic()).status(WAITING_FOR).clients(new ArrayList<Client>())
					.build());
			rooms.get(roomSize).setClients(client);
			return CREATED;
		} catch (Exception e) {
			return String.format("Error creating:: %s", e.getMessage());
		}
	}

	public String connectToRoom(Client client) {
		// The controller sends us the Client, we look in the List for the Client’s room
		Optional<Room> optionalRoom = rooms.stream().filter(room -> room.getName().equals(client.getExpectedRoom()))
				.findAny();
		// add Client to RoomCф1lients list
		optionalRoom.get().setClients(client);
		// return topic to user
		return optionalRoom.isPresent() ? optionalRoom.get().getName() : EMPTY;
	}

}
