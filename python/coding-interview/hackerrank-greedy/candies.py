def solution(n, arr):
    ans = [1] * n

    for i in range(n-1):
        if arr[i+1] > arr[i]:
            ans[i+1] = ans[i] + 1

    for i in range(n-1, 0, -1):
        if arr[i-1] > arr[i] and ans[i-1] <= ans[i]:
            ans[i-1] = ans[i] + 1

    return sum(ans)

if __name__ == "__main__":
    print(solution(3, [1,2,2]), "== 4")
    print(solution(10, [2, 4, 2, 6, 1, 7, 8, 9, 2, 1]), "== 19")
    print(solution(8, [2, 4, 3, 5, 2, 6, 4, 5]), "== 12")
    print(solution(3, [4, 3, 2]), "== 6")
