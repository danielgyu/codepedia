package message

type Request struct {
	Api    string
	Method string
	Data   map[string]interface{}
}
