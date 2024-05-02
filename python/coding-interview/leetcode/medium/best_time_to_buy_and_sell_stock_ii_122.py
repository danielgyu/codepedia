def max_profit(prices):
    profit = 0

    buy, cur_profit = 0, 0
    for i in range(1, len(prices)):
        if prices[i] < prices[i-1]:
            profit += cur_profit

            cur_profit = 0
            buy = i
        else:
            cur_profit = prices[i] - prices[buy]

    return profit + cur_profit


# leetcode
def max_profit(prices):
        profit = 0
        for i in range(1,len(prices)):
            if prices[i]>prices[i-1]:
                profit += (prices[i]-prices[i-1])
        return profit


if __name__ == "__main__":
    print(max_profit([7, 1, 5, 3, 6, 4]))
    print(max_profit([1, 2, 3, 4, 5]))
    print(max_profit([7, 6, 4, 3, 1]))
    print(max_profit([1]))
