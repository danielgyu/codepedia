package server

import (
	"context"
	"fmt"
	"log"
	"mayfly/sse/pkg/mq"
	"net/http"
)

func setSseHeaders(w http.ResponseWriter) {
	w.Header().Set("Access-Control-Allow-Origin", "*")
	w.Header().Set("Access-Control-Expose-Headers", "Content-Type")
	w.Header().Set("Content-Type", "text/event-stream")
	w.Header().Set("Cache-Control", "no-cache")
	w.Header().Set("Connection", "keep-alive")
}

func handleDisconnect(ctx context.Context) {
	select {
	case <-ctx.Done():
		err := ctx.Err()
		if err != nil {
			log.Print("[*] Client disconnected:", err)
		}
	}
	return
}

func StreamHandler(w http.ResponseWriter, r *http.Request) {
	setSseHeaders(w)

	ctx := r.Context()
	go handleDisconnect(ctx)

	chatChan := make(chan string)
	go mq.SubscribeChatStream(chatChan)

	for data := range chatChan {
		fmt.Fprintf(w, "data: %s\n", fmt.Sprintf("Event %s", data))
		w.(http.Flusher).Flush()
	}

	log.Print("[*] Stream ended")
}
