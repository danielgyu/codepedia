def solution(nums):
    smallest = 5001
    left, right = 0, len(nums)-1

    while left <= right:
        mid = (left+right) // 2

        smallest = min(smallest, nums[mid])
        if nums[left] > nums[mid] or nums[right] > nums[mid]:
            right = mid-1
        else:
            left = mid+1

    return smallest

if __name__ == "__main__":
    print(solution([3, 4, 5, 1, 2]))
    print(solution([1, 2, 3, 4, 5]))
    print(solution([11, 13, 15, 17]))
    print(solution([4, 5, 6, 7, 0, 1, 2]))
