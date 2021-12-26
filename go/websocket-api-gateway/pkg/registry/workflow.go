package registry

import (
	"errors"
	"log"

	"github.com/danielgyu/ws-gateway/pkg/message"
	"github.com/mitchellh/mapstructure"
)

func getWorkflow(data map[string]interface{}) (map[string]interface{}, error) {
	log.Printf("In get workflow\n")

	var workflowData message.GetWorkflow

	err := mapstructure.Decode(data, &workflowData)
	if err != nil {
		return nil, err
	}

	return map[string]interface{}{"name": "test_workflow"}, nil
}

func workflowRegistry(method string, data map[string]interface{}) (map[string]interface{}, error) {
	log.Printf("In workflow registry, method: %s, data: %v\n", method, data)

	switch method {
	case "GetWorkflow":
		response, err := getWorkflow(data)
		if err != nil {
			return nil, err
		}

		return response, nil
	default:
		return nil, errors.New("Cannot match request message")
	}
}
