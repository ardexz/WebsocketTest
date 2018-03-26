# WebsocketTest

Example code for Akka-HTTP: Single WebSocket Request

- singleWebSocketRequest takes a WebSocketRequest and a flow it will connect to the source and sink of the WebSocket connection. It will trigger the request right away and returns a tuple containing the Future[WebSocketUpgradeResponse] and the materialized value from the flow passed to the method.

The future will succeed when the WebSocket connection has been established or the server returned a regular HTTP response, or fail if the connection fails with an exception.

Simple example sending a message and printing any incoming message:
