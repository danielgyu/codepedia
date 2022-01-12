package main

import (
	"context"
	"fmt"

	"github.com/go-redis/redis/v8"
	rd "github.com/hismayfly/go-redis/internal/redis"
)

func publishEvent(rdb *redis.Client, count int) error {
	ctx := context.Background()
	err := rdb.XAdd(ctx, &redis.XAddArgs{
		Stream:       "goStream",
		MaxLen:       0,
		MaxLenApprox: 0,
		ID:           "",
		Values: map[string]interface{}{
			"name":  fmt.Sprintf("%s%d", "lee", count),
			"count": count + 10,
		},
	}).Err()

	return err
}

func main() {
	rdb := rd.NewRedisClient()

	for i := 0; i < 20; i++ {
		publishEvent(rdb, i)
	}
}
