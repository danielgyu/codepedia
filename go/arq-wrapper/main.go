package main

import (
	"context"
	"log"
	"time"

	"github.com/go-redis/redis/v8"
)

func main() {
	QueueName := "arq:queue"
	JobId := "51b9"
	Pickled := ""

	rdb := redis.NewClient(&redis.Options{
		Addr:     "localhost:6379",
		Password: "",
		DB:       0,
	})

	ctx := context.Background()

	pipe := rdb.Pipeline()

	err := pipe.Exists(ctx, "jobKey").Err()
	if err != nil {
		log.Fatal(err)
	}

	err = rdb.Watch(ctx, func(tx *redis.Tx) error {
		err := tx.SetEX(ctx, JobId, Pickled, time.Hour).Err()
		if err != nil {
			return err
		}

		pair := &redis.Z{Score: 86400, Member: JobId}
		err = tx.ZAdd(ctx, QueueName, pair).Err()
		if err != nil {
			return err
		}

		return err
	})
}
