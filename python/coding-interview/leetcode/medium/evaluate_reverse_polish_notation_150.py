def solution(tokens):
    stack = []
    for token in tokens:
        #print(f"{stack=}")
        if token == "+":
            stack.append(stack.pop() + stack.pop())
        elif token == "-":
            right, left= stack.pop(), stack.pop()
            stack.append(left - right)
        elif token == "*":
            stack.append(stack.pop() * stack.pop())
        elif token == "/":
            right, left = stack.pop(), stack.pop()
            stack.append(int(left / right))
        else:
            stack.append(int(token))
    return stack.pop()

if __name__ == "__main__":
    print(solution(tokens=["4", "3", "-"]))
    print(solution(tokens=["2", "1", "+", "3", "*"]))
    print(solution(tokens=["4", "13", "5", "/", "+"]))
    print(solution(tokens=["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]))
