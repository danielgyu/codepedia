import sys

def coin_change(coins, amount):
    if amount == 0:
        return 0

    coins.sort(reverse=True)
    counter = [sys.maxsize for _ in range(amount+1)]

    for coin in coins:
        count, idx = 0, coin

        for idx in range(1, amount+1):

            if idx % coin == 0:
                count += 1
                counter[idx] = min(counter[idx], count)

            if counter[idx] != sys.maxsize and idx+coin <= amount:
                counter[idx+coin] = min(
                    counter[idx+coin],
                    counter[idx]+1,
                )

    return counter[-1] if counter[-1] != sys.maxsize else -1


if __name__ == "__main__":
    print(coin_change([1, 2, 5], 11))
    print(coin_change([2], 3))
    print(coin_change([1], 0))
    print(coin_change([1, 2], 0))
    print(coin_change([1,2,5], 100))
    print(coin_change([186, 419, 83, 408], 6249))
