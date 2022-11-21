def solution(n):
    if n < 2:
        return 1

    left, right = 1, 1
    for _ in range(2, n+1):
        left, right = right, left + right

    return right

if __name__ == "__main__":
    print(solution(1))
    print(solution(2))
    print(solution(3))
    print(solution(4))
    print(solution(18))
