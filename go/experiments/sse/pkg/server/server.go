package server

import (
	"log"
	"net/http"
)

func Run() {
	log.Print("[*] Starting server...")

	http.HandleFunc("/stream", StreamHandler)
	http.ListenAndServe(":8080", nil)
}
