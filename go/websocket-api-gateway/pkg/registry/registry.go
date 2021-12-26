package registry

import (
	"errors"
	"log"

	"github.com/danielgyu/ws-gateway/pkg/message"
)

func Process(msg message.Request) (map[string]interface{}, error) {
	log.Printf("Processing message: %s\n", msg)

	switch msg.Api {
	case "Workflow":
		response, err := workflowRegistry(msg.Method, msg.Data)
		if err != nil {
			return nil, err
		}
		return response, nil
	default:
		return nil, errors.New("Cannot match request message")
	}
}
