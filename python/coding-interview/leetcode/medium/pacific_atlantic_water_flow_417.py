import pprint

pp = pprint.PrettyPrinter(indent=4)

def solution_dfs_exceed_time_limit(heights):
    PACIFIC = 0
    ATLANTIC = 1
    rows, cols = len(heights), len(heights[0])

    def explore(row, col, visited, water, seen):
        if (row, col) in seen:
            water[PACIFIC] = True
            water[ATLANTIC] = True
            return
        if visited[row][col] == True:
            return
        if row == 0 or col == 0:
            water[PACIFIC] = True
        if row == rows-1 or col == cols-1:
            water[ATLANTIC] = True

        visited[row][col] = True

        cur = heights[row][col]
        if row > 0 and cur >= heights[row-1][col]:
            explore(row-1, col, visited, water, seen)
        if row < rows-1 and cur >= heights[row+1][col]:
            explore(row+1, col, visited, water, seen)
        if col > 0 and cur >= heights[row][col-1]:
            explore(row, col-1, visited, water, seen)
        if col < cols-1 and cur >= heights[row][col+1]:
            explore(row, col+1, visited, water, seen)

        visited[row][col] = False

    res, seen = list(), set()
    visited = [[False for _ in range(cols)] for _ in range(rows)] 
    for row in range(rows):
        for col in range(cols):
            water = [False, False]
            explore(row, col, visited, water, seen)
            if all(water):
                seen.add((row, col))
                res.append([row, col])

    return res


def solution(heights):
    rows, cols = len(heights), len(heights[0])

    def dfs(row, col, visited):
        if (row, col) in visited:
            return
        
        visited.add((row, col))

        cur = heights[row][col]
        if row > 0 and cur <= heights[row-1][col]:
            dfs(row-1, col, visited)
        if row < rows-1 and cur <= heights[row+1][col]:
            dfs(row+1, col, visited)
        if col > 0 and cur <= heights[row][col-1]:
            dfs(row, col-1, visited)
        if col < cols-1 and cur <= heights[row][col+1]:
            dfs(row, col+1, visited)

    pacific, atlantic = set(), set()
    # top
    for i in range(cols):
        dfs(0, i, pacific)
        dfs(rows-1, i, atlantic)
    # left
    for i in range(rows):
        dfs(i, 0, pacific)
        dfs(i, cols-1, atlantic)

    return list(pacific.intersection(atlantic))


if __name__ == "__main__":
    print(solution([
        [1, 2, 2, 3, 5],
        [3, 2, 3, 4, 4],
        [2, 4, 5, 3, 1],
        [6, 7, 1, 4, 5],
        [5, 1, 1, 2, 4]
    ]))
    print([[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]])
    print()

    print(solution([
        [2, 1],
        [1, 2],
    ]))
    print([[0,0], [0,1], [1,0], [1,1]])
