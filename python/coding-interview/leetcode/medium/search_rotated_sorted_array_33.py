def solution(nums, target):
    left, right = 0, len(nums)-1

    while left <= right:
        mid = (left+right) // 2
        #print(nums[left:right+1], mid)

        if nums[mid] == target:
            return mid

        if nums[mid] >= nums[left]:
            #print("1 left sorted")
            if nums[left] <= target < nums[mid]:
                #print("left")
                right = mid-1
            else:
                #print("right")
                left = mid+1
        else:
            #print("1 right sorted")
            if target <= nums[right] and nums[mid] < target:
                #print("left")
                left = mid+1
            else:
                #print("right")
                right = mid-1

    return -1


if __name__ == "__main__":
    print(solution([6, 7, 8, 0, 1, 2, 3, 4, 5], 0))
    print(solution([4, 5, 6, 7, 0, 1, 2], 0))
    print(solution([4, 5, 6, 7, 0, 1, 2], 3))
    print(solution([1, 3], 0))
    print(solution([1, 3], 3))
