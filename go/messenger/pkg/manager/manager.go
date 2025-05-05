package manager

import (
	"log"
	error_ "mayfly/messenger/pkg/error"
	"mayfly/messenger/pkg/mq"
	"mayfly/messenger/pkg/parser"
)

func Run() {
	log.Printf("[*] Spinning up manager...")

	connectionUrl := "amqp://modelhubuser:modelhubpass@localhost:5672/modelhubvhost"
	mqHandler := mq.MessageQueue{
		ConnectionUrl: connectionUrl,
		QueueName:     "go-test-queue",
		Connection:    nil,
	}
	mqHandler.Connect()

	//dbHandler := ?
	//parser := ?

	for d := range mqHandler.Consume() {
		parsed, err := parser.Parse(d.Body)
		if err != nil {
			error_.FailOnError(err, "")
		}

		log.Printf("[*] parsed: %s", parsed)
	}
}
