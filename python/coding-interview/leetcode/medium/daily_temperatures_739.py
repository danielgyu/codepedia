def solution(temperatures):
    answer = [0] * len(temperatures)
    stack = list()

    for i in range(len(temperatures)):
        while stack and temperatures[i] > temperatures[stack[-1]]:
            top_idx = stack.pop()
            answer[top_idx] = i - top_idx

        stack.append(i)

    return answer


if __name__ == "__main__":
    print(solution([73, 74, 75, 71, 69, 72, 76, 73]))
    print(solution([30, 40, 50, 60]))
