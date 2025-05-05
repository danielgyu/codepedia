package experiments

import (
	"context"
	"log"
	"time"

	amqp "github.com/rabbitmq/amqp091-go"
)

func failOnError(err error, msg string) {
	if err != nil {
		log.Panicf("%s: %s", msg, err)
	}
}

func publish(q amqp.Queue, ch *amqp.Channel) {
	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancel()

	body := "Hello World!"
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
	failOnError(err, "Failed to publish message")
	log.Printf(" [x] sent %s\n", body)
}

func consume(q amqp.Queue, ch *amqp.Channel) {
	consumer, err := ch.Consume(
		q.Name,
		"go-test-consumer",
		true,
		false,
		false,
		false,
		nil,
	)
	failOnError(err, "Failed to register consumer")

	go func() {
		for d := range consumer {
			log.Printf("Received message :%s", d.Body)
		}
	}()

	log.Printf(" [*] Waiting for messages...")

	var forever chan struct{}
	<-forever
}

func main() {
	conn, err := amqp.Dial("amqp://modelhubuser:modelhubpass@localhost:5672/modelhubvhost")
	failOnError(err, "Failed to connecto to Rabbitmq")
	defer conn.Close()

	ch, err := conn.Channel()
	failOnError(err, "Failed to open a channel")
	defer ch.Close()

	q, err := ch.QueueDeclare(
		"go-test-queue",
		false,
		false,
		false,
		false,
		nil,
	)
	failOnError(err, "Failed to declare queue")

	publish(q, ch)
	consume(q, ch)
}
