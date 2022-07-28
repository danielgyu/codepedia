def solution(heights):
    most = 0
    left, right = 0, len(heights)-1

    while left < right:
        current = min(heights[left], heights[right]) * (right - left)
        most = max(most, current)

        if heights[left] <= heights[right]:
            left += 1
        else:
            right -= 1

    return most


if __name__ == "__main__":
    print(solution([1, 8, 6, 2, 5, 4, 8, 3, 7]))
    print(solution([1, 1]))
    print(solution([2, 3, 4, 5, 18, 17, 6]))
