package web.socket.server.rooms;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import web.socket.server.rooms.repository.FirstRoom;
import web.socket.server.rooms.repository.SecondRoom;

@Service
public class RoomService {

	// After creating RoomRepository in this ArrayList will be added Rooms Object
	private ArrayList<Room> rooms = new ArrayList<>();
	{
		rooms.add(Room.builder().id(1).name("firstRoom").status("free").actualRoom(FirstRoom.builder().build()).build());
		rooms.add(Room.builder().id(2).name("secondRoom").status("busy").actualRoom(SecondRoom.builder().build()).build());
	}

	public Boolean checkFreeRoomAndConnect() {
		// After creating the rooms, this function will take the Client class argument
		return (rooms.contains("free")) ? true : false; // in the future he will send Free/Closed Rooms
	}
}
