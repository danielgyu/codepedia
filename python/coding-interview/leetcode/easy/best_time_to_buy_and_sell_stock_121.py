def max_profit(prices):
    profit = 0

    min_ = prices[0]
    for price in prices:
        if price < min_:
            min_ = price

        profit = max(profit, price-min_)

    return profit


if __name__ == "__main__":
    print(max_profit([7, 1, 5, 3, 6, 4]))
    print(max_profit([7, 6, 4, 3, 1]))
    print(max_profit([1]))
