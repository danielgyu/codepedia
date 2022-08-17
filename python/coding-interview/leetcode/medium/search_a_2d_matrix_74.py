def solution(matrix, target):
    h, w = len(matrix), len(matrix[0])

    left, right = 0, h*w-1
    while left <= right:
        mid = (left+right) // 2
        mid_h, mid_w = divmod(mid, w)

        if matrix[mid_h][mid_w] == target:
            return True
        elif matrix[mid_h][mid_w] > target:
            right = mid-1
        else:
            left = mid+1

    return False


if __name__ == "__main__":
    print(solution(
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3
    ))
    print(solution(
        [[1]], 2
    ))
    print(solution(
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 13
    ))
