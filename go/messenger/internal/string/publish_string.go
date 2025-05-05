package main

import (
	"context"
	"log"
	"time"

	amqp "github.com/rabbitmq/amqp091-go"

	error_ "mayfly/messenger/pkg/error"
)

func main() {
	conn, err := amqp.Dial("amqp://modelhubuser:modelhubpass@localhost:5672/modelhubvhost")
	error_.FailOnError(err, "Failed to connecto to Rabbitmq")
	defer conn.Close()

	ch, err := conn.Channel()
	error_.FailOnError(err, "Failed to open a channel")
	defer ch.Close()

	q, err := ch.QueueDeclare(
		"go-test-queue",
		false,
		false,
		false,
		false,
		nil,
	)
	error_.FailOnError(err, "Failed to declare queue")

	publish(q, ch)
}

func publish(q amqp.Queue, ch *amqp.Channel) {
	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancel()

	bodies := []string{"stream1", "stream2", "<<END>>"}
	for _, body := range bodies {
		err := ch.PublishWithContext(ctx,
			"",
			q.Name,
			false,
			false,
			amqp.Publishing{
				ContentType: "text/plain",
				Body:        []byte(body),
			},
		)
		error_.FailOnError(err, "Failed to publish message")
		log.Printf(" [x] sent %s\n", body)
	}
}
