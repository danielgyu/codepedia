package server

import (
	"log"
	"net/http"

	"github.com/danielgyu/ws-gateway/pkg/message"
	"github.com/danielgyu/ws-gateway/pkg/registry"
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
		reqMsg := message.Request{}
		err = c.ReadJSON(&reqMsg)
		if err != nil {
			log.Printf("Read message error: %s\n", err)
			break
		}

		response, err := registry.Process(reqMsg)
		if err != nil {
			log.Printf("Process error: %s\n", err)
			break
		}

		err = c.WriteJSON(response)
		if err != nil {
			log.Printf("Write message error: %s", err)
			break
		}

	}
}
