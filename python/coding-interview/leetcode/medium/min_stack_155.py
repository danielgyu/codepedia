class MinStack:
    def __init__(self):
        self.stack = []

    def push(self, val):
        if self.stack:
            smaller = min(val, self.stack[-1][1])
            self.stack.append((val, smaller))
        else:
            self.stack.append((val, val))

    def pop(self):
        if self.stack:
            self.stack.pop()

    def top(self):
        if self.stack:
            return self.stack[-1][0]
        return -1

    def getMin(self):
        if self.stack:
            return self.stack[-1][1]
        return -1


if __name__ == "__main__":
    s = MinStack()
    s.push(-2)
    s.push(0)
    s.push(-3)
    print(s.getMin())
    s.pop()
    print(s.top())
    print(s.getMin())
