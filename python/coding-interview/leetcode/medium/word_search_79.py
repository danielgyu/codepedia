def solution(board, word):
    length, width = len(board), len(board[0])

    def dfs(row, col, idx):
        if row < 0 or row >= length or col < 0 or col >= width:
            return False

        if board[row][col] == "-":
            return False

        if board[row][col] != word[idx]:
            return False

        if idx == len(word)-1:
            return True

        temp = board[row][col]
        board[row][col] = "-"

        for x, y in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            if dfs(row+x, col+y, idx+1):
                return True

        board[row][col] = temp

    for i in range(length):
        for j in range(width):
            if dfs(i, j, 0):
                return True

    return False

if __name__ == "__main__":
    print(solution(
        [
            ["A","A","C","E"],
            ["S","F","A","S"],
            ["A","D","C","A"],
            ["A","A","C","A"]
        ],
        "AACACA"
    ))
    """
    print(solution(
        [
            ["A", "B", "C", "E"],
            ["S", "F", "C", "S"],
            ["A", "D", "E", "E"],
        ],
        "ABCCED"
    ))
    print(solution(
        [
            ["A","B","C","E"],
            ["S","F","C","S"],
            ["A","D","E","E"]
        ],
        "ABCB"
    ))
    print(solution(
        [
            ["A"]
        ],
        "A"
    ))
    print(solution(
        [
            ["A","B","C","E"],
            ["S","F","E","S"],
            ["A","D","E","E"],
        ],
        "ABCESEEEFS"
    ))
    print(solution(
        [
            ["A", "A", "A", "A"],
            ["A", "A", "A", "A"],
            ["A", "A", "A", "A"],
        ],
        "AAAAAAAAAAAAA"
    ))
    print(solution(
        [
            ["A", "B", "C", "E"],
            ["S", "F", "C", "S"],
            ["A", "D", "E", "E"],
        ],
        "CSEED"
    ))
    print(solution(
        [
            ["Z", "B", "C", "E"],
            ["S", "F", "C", "S"],
            ["A", "D", "E", "E"],
        ],
        "BCCED"
    ))
    """
