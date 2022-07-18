from collections import defaultdict


def solution(board):
    row_dict = defaultdict(set)
    col_dict = defaultdict(set)
    sub_box_dict = defaultdict(set)

    for row in range(9):
        for col in range(9):
            num = board[row][col]
            
            if num == ".":
                continue

            sub_box = (row // 3, col // 3)

            if (num in row_dict[row] or
                num in col_dict[col] or
                num in sub_box_dict[sub_box]):
                return False

            row_dict[row].add(num)
            col_dict[col].add(num)
            sub_box_dict[sub_box].add(num)

    return True


if __name__ == "__main__":
    print(solution([
        ["5","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"],
    ]))

    print(solution([
        ["8","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"],
    ]))
