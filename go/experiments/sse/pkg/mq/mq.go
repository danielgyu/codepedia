package mq

import (
	amqp "github.com/rabbitmq/amqp091-go"
)

func createRabbitmqChannel() *amqp.Channel {
	connectionUrl := "amqp://modelhubuser:modelhubpass@localhost:5672/modelhubvhost"
	conn, connErr := amqp.Dial(connectionUrl)
	if connErr != nil {
		panic("Failed to connect to rabbitmq")
	}

	ch, chanErr := conn.Channel()
	if chanErr != nil {
		panic("Failed to connect to channel")
	}

	_, queueErr := ch.QueueDeclare(
		"go-test-queue",
		false,
		false,
		false,
		false,
		nil,
	)
	if queueErr != nil {
		panic("Failed to connect to declare queue")
	}

	return ch
}

func SubscribeChatStream(c chan string) {
	mqChan := createRabbitmqChannel()

	consumer, err := mqChan.Consume(
		"go-test-queue",
		"go-test-consumer",
		true,
		false,
		false,
		false,
		nil,
	)
	if err != nil {
		panic("Failed to consume from queue")
	}

	for d := range consumer {
		str := string(d.Body)
		c <- str

		if str == "<<END>>" {
			close(c)
			break
		}
	}
}
