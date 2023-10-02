from collections import deque

def match(user_id, banned_id):
    if len(user_id) != len(banned_id):
        return False
    for u, b in zip(user_id, banned_id):
        if b == "*":
            continue
        if b == u:
            continue
        break
    else:
        return True
    return False


def solution(user_ids, banned_ids):
    answer = set()

    queue = deque()
    # populate queue with first element of banned_ids
    for user_id in user_ids:
        matched = match(user_id, banned_ids[0])
        if matched:
            queue.append((user_id,))

    # DFS from second element of banned_ids
    while len(queue) != 0:
        used_user_ids = queue.pop()
        if len(used_user_ids) == len(banned_ids):
            hashed = 0
            for user_id in used_user_ids:
                hashed += hash(user_id)
            if hashed not in answer:
                answer.add(hashed)
            continue

        # what are the remaining user ids?
        remaining_user_ids = [u for u in user_ids if u not in used_user_ids]

        # what is the target banned id?
        target_banned_id = banned_ids[len(used_user_ids)]

        # any matches?
        for user_id in remaining_user_ids:
            matched = match(user_id, target_banned_id)
            if matched:
                new_used_user_ids = used_user_ids + (user_id,)
                queue.append(new_used_user_ids)
    
    print(f"{len(answer)=}")
    return len(answer)

if __name__ == "__main__":
    solution(
        ["frodo", "fradi", "crodo", "abc123", "frodoc"],
        ["fr*d*", "*rodo", "******", "******"],
    )

    solution(
        ["frodo", "fradi", "crodo", "abc123", "frodoc"],
        ["fr*d*", "abc1**"],
    )

    solution(
        ["frodo", "fradi", "crodo", "abc123", "frodoc"],
        ["*rodo", "*rodo", "******"],
    )
