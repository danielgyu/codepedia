def solution(target, position, speed):
    pair = [(p, s) for p, s in zip(position, speed)]

    stack = []
    for p, s in sorted(pair)[::-1]:
        stack.append((target-p)/s)
        if len(stack) > 1 and stack[-1] <= stack[-2]:
            stack.pop()

    return len(stack)


def upvoted(target, position, speed):
    time = [float(target-p)/s for p, s in sorted(zip(position, speed))]

    res = cur = 0
    for t in time[::-1]:
        if t > cur:
            res += 1
            cur = t

    return res



if __name__ == "__main__":
    print(upvoted(12, [10, 8, 0, 5, 3], [2, 4, 1, 1, 3]))
    print(upvoted(10, [3], [3]))
    print(upvoted(100, [0, 2, 4], [4, 2, 1]))
    print(upvoted(10, [0, 4, 2], [2, 1, 3]))
    """
    print(solution(12, [10, 8, 0, 5, 3], [2, 4, 1, 1, 3]))
    print(solution(10, [3], [3]))
    print(solution(100, [0, 2, 4], [4, 2, 1]))
    print(solution(10, [0, 4, 2], [2, 1, 3]))
    """
