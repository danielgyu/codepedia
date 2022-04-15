def solution(calorie):
    calorie = sorted(calorie, reverse=True)

    ans = 0
    for i in range(len(calorie)):
        cur = calorie[i] * pow(2, i)
        ans += cur

    return ans

print(solution([1, 3, 2]))
print(solution([7, 4, 9, 6]))
