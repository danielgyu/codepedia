from math import inf

alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
alpha_length = 26

def joystick(name):
    diffs = list()
    for n in name:
        if n != "A":
            n_idx = alphabets.index(n)
            left = 26 - n_idx
            right = n_idx - 0
            diffs.append(min(left, right))
        else:
            diffs.append(0)

    seen = set(i for i, d in enumerate(diffs) if d == 0)
    count, position = 0, 0
    while len(seen) < len(diffs):
        min_move = inf
        for i, diff in enumerate(diffs):
            if i not in seen and diff != 0:
                left = abs(i - position)
                right = abs(len(name) - i + position)
                move = min(left, right)

                if move < min_move:
                    min_move = move
                    position = i

        count += min_move
        count += diffs[position]
        seen.add(position)

    return count

print(joystick("JEROEN"))
print(joystick("JAN"))
print(joystick("JAZ"))
