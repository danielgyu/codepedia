package main

import (
	"context"
	"fmt"
	"log"
	"time"

	"github.com/go-redis/redis/v8"
	rd "github.com/hismayfly/go-redis/internal/redis"
)

func subscribeForever(ch <-chan *redis.Message) {
	for msg := range ch {
		log.Println("received message: ", msg.Channel, msg.Payload)
	}
}

func main() {
	ctx := context.Background()

	rdb := rd.NewRedisClient()

	pubsub := rdb.Subscribe(ctx, "myChannel")

	res, err := pubsub.Receive(ctx)
	if err != nil {
		log.Fatal(err)
	}
	log.Println("res: ", res)

	ch := pubsub.Channel()

	go subscribeForever(ch)

	loop := 0
	for loop < 1 {
		fmt.Println("sleeping for 10 seconds")
		time.Sleep(1e10)
	}
}
