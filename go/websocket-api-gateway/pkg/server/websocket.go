package server

import (
	"log"
	"net/http"

	"github.com/gorilla/websocket"
)

var upgrader = websocket.Upgrader{
	ReadBufferSize:  1024,
	WriteBufferSize: 1024,
}

func wsJSON(w http.ResponseWriter, r *http.Request) {
	c, err := upgrader.Upgrade(w, r, nil)
	if err != nil {
		log.Printf("WebSocket upgrade error: %s", err)
		return
	}
	defer c.Close()

	for {
		var reqMsg map[string]interface{}
		err = c.ReadJSON(&reqMsg)
	}
}

func wsEndpoint(w http.ResponseWriter, r *http.Request) {
	c, err := upgrader.Upgrade(w, r, nil)
	if err != nil {
		log.Printf("WebSocket upgrade error: %s", err)
		return
	}
	defer c.Close()

	for {
		msgType, msg, err := c.ReadMessage()
		if err != nil {
			log.Printf("Read message error: %s", err)
			break
		}

		log.Printf("Received message: %s", msg)

		err = c.WriteMessage(msgType, []byte("ws return"))
		if err != nil {
			log.Printf("Write message error: %s", err)
			break
		}
	}
}
