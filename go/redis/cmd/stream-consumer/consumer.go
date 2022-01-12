package main

import (
	"context"
	"log"

	"github.com/go-redis/redis/v8"
	rd "github.com/hismayfly/go-redis/internal/redis"
)

func createNewGroup(rdb *redis.Client) {
	ctx := context.Background()
	err := rdb.XGroupCreate(ctx, "goStream", "goGroup2", "$").Err()
	if err != nil {
		log.Fatal("error creating gxgroup: ", err)
	}

	log.Println("successfully created new group")
}

func consumeEvent(rdb *redis.Client) {
	ctx := context.Background()
	for {
		event, err := rdb.XReadGroup(ctx, &redis.XReadGroupArgs{
			Group:    "goGroup",
			Consumer: "consumerOne",
			Streams:  []string{"goStream", ">"},
			Count:    1,
			Block:    0,
			NoAck:    false,
		}).Result()
		if err != nil {
			log.Fatal(err)
		}

		log.Printf("event: %+v", event)
	}
}

func main() {
	rdb := rd.NewRedisClient()

	createNewGroup(rdb)
	consumeEvent(rdb)
}
