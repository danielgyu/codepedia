from collections import defaultdict

def task_assignment(k, tasks):
    task_map = defaultdict(list)
    for idx, t in enumerate(tasks):
        task_map[t].append(idx)

    sorted_tasks = sorted(tasks)
    ans = list()
    left, right = 0, len(sorted_tasks)-1

    while left < right:
        l_idx = task_map[sorted_tasks[left]].pop()
        r_idx = task_map[sorted_tasks[right]].pop()
        ans.append([l_idx, r_idx])

        left += 1
        right -=1

    return ans


if __name__ == "__main__":
    print(task_assignment(3, [1, 3, 5, 3, 1, 4]))
