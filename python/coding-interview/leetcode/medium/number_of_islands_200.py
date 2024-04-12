def nums_islands(grid):
    visited = [
        [False for _ in range(len(grid[0]))]
        for _ in range(len(grid))
    ]

    def explore(row, col):
        if (
            row < 0 or
            row >= len(grid) or
            col < 0 or
            col >= len(grid[0])
        ):
            return 0

        if visited[row][col] is True or grid[row][col] == "0":
            return 0

        visited[row][col] = True

        explore(row+1, col)
        explore(row-1, col)
        explore(row, col+1)
        explore(row, col-1)
        return 1


    res = 0
    for row in range(len(grid)):
        for col in range(len(grid[0])):
            res += explore(row, col)

    print(res)
    return res

if __name__== "__main__":
    nums_islands([
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"],
    ])


    nums_islands([
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"],
    ])
