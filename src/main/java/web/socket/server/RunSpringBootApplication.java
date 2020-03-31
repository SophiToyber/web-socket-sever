package web.socket.server;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(RunSpringBootApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8086"));
		app.run(args);

	}

}
