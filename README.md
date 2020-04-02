# About

This WebSocket server is an application for processing messages, or in other words a server for a messenger.

## Installation

```bash
You can install this server with: https://gitlab.com/SophiToyber/web-socket-server.git
```

## Getting started

### In Eclipse

Click on File -> Import -> Existing Gradle Project . Indicate your project root directory and click finish.

Right click on web-socker-server -> Gradle -> Refresh Gradle Project

Next open Boot Dashboar and left click on start/restart project icon.

## Technology

To write the application, I used the [Spring Boot](https://spring.io/projects/spring-boot)  and its tools for working with Web Sockets.
The server uses Web Socket technology to establish a connection with the user.

**WebSocket** provides two-way communication between the client and server using a single TCP connection.

Principles of the application:
The client sends a request to create / connect to the room ->
-> the server processes the request and sends the client to a specific communication channel ->
-> then the endpoint is registered with **SockJs** or **Stomp** , which will intercept messages sent by the user to a specific topic 