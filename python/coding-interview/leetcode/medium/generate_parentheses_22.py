def solution(N):
    stack = []
    answer = []

    def backtrack(open_n, closed_n):
        if open_n == closed_n == N:
            answer.append("".join(stack))
            return
        
        if open_n < N:
            stack.append("(")
            backtrack(open_n+1, closed_n)
            stack.pop()

        if closed_n < open_n:
            stack.append(")")
            backtrack(open_n, closed_n+1)
            stack.pop()

    backtrack(0, 0)
    return answer


if __name__ == "__main__":
    print(solution(3))
    print(solution(1))
