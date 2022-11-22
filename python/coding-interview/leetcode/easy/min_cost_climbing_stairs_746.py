def solution(cost):
    dp = [0 for _ in range(len(cost)+1)]

    for i in range(2, len(dp)):
        dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])

    return dp[-1]


if __name__ == "__main__":
    print(solution([1, 2]))
    print(solution([10, 15, 20]))
    print(solution([1, 100, 1, 1, 1, 100, 1, 1, 100, 1]))
