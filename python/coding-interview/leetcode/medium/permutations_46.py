def indent(idx):
    print(" " * idx*2, end="")

def solution(nums):
    ans = []

    def backtrack(idx):
        if idx == len(nums):
            ans.append(nums[:])
            indent(idx)
            print(f"return {idx=}")
            return

        indent(idx)
        print(f"for {idx=} in range({idx}, {len(nums)})",end=" ")
        print(f"{ans=}")
        for i in range(idx, len(nums)):
            nums[idx], nums[i] = nums[i], nums[idx]

            indent(idx)
            print(f"{i=}, backtrack({idx=}+1)")
            backtrack(idx+1)

            nums[idx], nums[i] = nums[i], nums[idx]

        indent(idx)
        print("exit", f"{idx=}, {ans=}")
        print()

    backtrack(0)
    return ans



if __name__ == "__main__":
    solution([1,2,3])
    #solution([5,4,6,2])
