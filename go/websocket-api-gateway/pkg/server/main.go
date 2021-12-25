package server

import (
	"log"
	"net/http"
)

func RunGateway() {
	http.HandleFunc("/ws", wsEndpoint)
	http.HandleFunc("/health", healthcheck)

	port := ":8000"
	log.Printf("Listening on port %s", port)
	log.Fatal(http.ListenAndServe(port, nil))
}
