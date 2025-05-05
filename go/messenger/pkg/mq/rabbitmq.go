package mq

import (
	"log"
	error_ "mayfly/messenger/pkg/error"

	amqp "github.com/rabbitmq/amqp091-go"
)

type MessageQueue struct {
	ConnectionUrl string
	QueueName     string
	Connection    *amqp.Connection
	Channel       *amqp.Channel
}

func (mq *MessageQueue) Connect() *MessageQueue {
	conn, connErr := amqp.Dial(mq.ConnectionUrl)
	error_.FailOnError(connErr, "Failed to connecto to Rabbitmq")

	ch, chanErr := conn.Channel()
	error_.FailOnError(chanErr, "Failed to open a channel")

	_, queueErr := ch.QueueDeclare(
		mq.QueueName,
		false,
		false,
		false,
		false,
		nil,
	)
	error_.FailOnError(queueErr, "Failed to declare queue")

	mq.Connection = conn
	mq.Channel = ch
	return mq
}

func (mq *MessageQueue) Consume() <-chan amqp.Delivery {
	log.Printf("[*] Waiting to consume %s", mq.QueueName)

	consumer, err := mq.Channel.Consume(
		mq.QueueName,
		"go-test-consumer",
		true,
		false,
		false,
		false,
		nil,
	)
	error_.FailOnError(err, "Failed to make queue consumer")
	return consumer
}
