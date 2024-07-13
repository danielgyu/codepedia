def jump(nums: list[int]) -> int:
    ans = mx = last = 0

    for i, x in enumerate(nums[:-1]):
        print(f"{i=}, {ans=}, {mx=}, {last=}")
        mx = max(mx, i + x)
        if last == i:
            ans += 1
            last = mx
        print(f"{i=}, {ans=}, {mx=}, {last=}")
        print()

    return ans


if __name__ == "__main__":
    print(jump([2, 3, 0, 1, 4]))
