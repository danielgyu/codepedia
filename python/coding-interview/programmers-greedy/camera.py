def solution(routes):
    routes.sort(key=lambda x: x[1])
    camera = -30001
    answer = 0

    for route in routes:
        if camera >= route[0]:
            continue
        else:
            answer += 1
            camera = route[1]

    return answer



print(solution([[-20,-15], [-14, -5], [-18, -13], [-5,-3]]))
print(solution([[30, 40], [20, 60]]))
print(solution([[10, 20]]))
