package error_

import "fmt"

func FailOnError(err error, msg string) {
	if err != nil {
		panic(fmt.Sprintf("%s: %s", err, msg))
	}
}
