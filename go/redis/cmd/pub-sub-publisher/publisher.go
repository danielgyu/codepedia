package main

import (
	"context"
	"log"

	rd "github.com/hismayfly/go-redis/internal/redis"
)

func main() {
	ctx := context.Background()

	rdb := rd.NewRedisClient()

	if err := rdb.Publish(ctx, "myChannel", "hello").Err(); err != nil {
		log.Fatal(err)
	}
}
