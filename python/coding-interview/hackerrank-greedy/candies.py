def solution(n, arr):
    ans = [0] * n
    ans[0] = 1

    for i in range(1, n):
        if arr[i] > arr[i-1]:
            ans[i] = ans[i-1] + 1
        elif arr[i] == arr[i-1]:
            ans[i] = 1
        else:
            ans[i] = 1
            j = i-1
            while j >= 0 and arr[j] > arr[j+1] and ans[j] <= ans[j+1]:
                ans[j] = ans[j+1] + 1
                j -= 1

    print(ans)
    return sum(ans)

if __name__ == "__main__":
    #print(solution(3, [1,2,2]))
    print(solution(10, [2, 4, 2, 6, 1, 7, 8, 9, 2, 1]))
    #print(solution(8, [2, 4, 3, 5, 2, 6, 4, 5]))
    print(solution(3, [4, 3, 2]))
