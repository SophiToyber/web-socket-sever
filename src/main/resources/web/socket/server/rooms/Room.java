package web.socket.server.rooms;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.socket.server.clients.Client;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {

	private Integer id;
	private String name;
	private String status;
	private Object actualRoom;
	private ArrayList<Client> clients;

	public void setClient(Client client) {
		this.clients.add(client);
	}

	public Boolean isWaitingMatch(Client incomingClient) {
		return clients.contains(incomingClient) ? true : false;
	}
}
