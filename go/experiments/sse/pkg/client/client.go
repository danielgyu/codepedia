package main

import (
	"github.com/r3labs/sse/v2"
)

func run() {
	client := sse.NewClient("http://localhost:8080/stream")
}
