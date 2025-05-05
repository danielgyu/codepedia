package parser

import (
	"encoding/json"
	"errors"
)

type EventMessage struct {
	Type string          `json:"eventType"`
	Data json.RawMessage `json:"data"` // parses to the following types
}

type TypeFoo struct {
	Foo string `json:"foo"`
}

type TypeBar struct {
	Bar string `json:"bar"`
}

func Parse(data []byte) (any, error) {
	var eventMsg EventMessage
	if err := json.Unmarshal(data, &eventMsg); err != nil {
		return nil, err
	}

	switch eventMsg.Type {
	case "FOO":
		var foo TypeFoo
		if err := json.Unmarshal(eventMsg.Data, &foo); err != nil {
			return nil, err
		}
		return foo, nil

	case "BAR":
		var bar TypeBar
		if err := json.Unmarshal(eventMsg.Data, &bar); err != nil {
			return nil, err
		}
		return bar, nil
	}

	return nil, errors.New("Failed to parse")
}
