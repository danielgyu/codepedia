package main

import (
	"context"
	"fmt"
	"log"

	_ "github.com/go-sql-driver/mysql"
	"github.com/hismayfly/ent-ing/ent"
)

func main() {
	client, err := ent.Open(
		"mysql",
		"test:test@/entdb",
	)
	if err != nil {
		log.Fatalf("failed to connect to db %s", err)
	}
	defer client.Close()

	ctx := context.Background()
	if err := client.Schema.Create(ctx); err != nil {
		log.Fatalf("failed to create schema resource %s", err)
	}

	CreateUser(ctx, client)
}

func CreateUser(ctx context.Context, client *ent.Client) (*ent.User, error) {
	u, err := client.User.
		Create().
		SetAge(30).
		SetName("lee").
		Save(ctx)
	if err != nil {
		return nil, fmt.Errorf("failed to create user: %w", err)
	}

	log.Println("user was created: ", u)
	return u, nil
}
