def climbStairs(n):
    if n <= 2:
        return n

    dp = [0 for _ in range(n)]
    dp[0], dp[1] = 1, 2

    for i in range(2, n):
        dp[i] = dp[i-1] + dp[i-2]

    #breakpoint()
    return dp[n-1]


if __name__ == "__main__":
    print(climbStairs(2))
    print(climbStairs(3))
