def solution(number, k):
    total = len(number) - k
    ans = ""

    # 채워야하는 숫자 -1을 제외하고 가장 큰수 찾기
    start, end = 0, len(number)
    for i in range(total-1, -1, -1):
        biggest = -1

        for j in range(start, end-i):
            if int(number[j]) > biggest:
                biggest = int(number[j])
                start = j+1
                if biggest == 9: break

        ans += str(biggest)

    return ans


print(solution("1924", 2))
print(solution("1231234", 3))
print(solution("4177252841", 4))
