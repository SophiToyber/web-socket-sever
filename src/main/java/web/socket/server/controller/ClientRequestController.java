package web.socket.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/check")
public class ClientRequestController {

	@PostMapping("/")
	public void post() {

	}

	@GetMapping()
	public void get() {

	}

}
