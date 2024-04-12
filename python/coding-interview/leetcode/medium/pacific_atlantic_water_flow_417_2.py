def get_directions(row, col):
    return [
        (row+1, col),
        (row-1, col),
        (row, col+1),
        (row, col-1),
    ]

def pacific_atlantic(heights):
    result = []

    def search(row, col, prev_val, visited, flowed):
        coord = (row, col)
        if coord in visited:
            return

        # pacific
        if row <= -1 or col <= -1:
            flowed["p"] = True
            return

        # atlantic
        if row >= len(heights) or col >= len(heights[0]):
            flowed["a"] = True
            return

        if prev_val < heights[row][col]:
            return


        visited.add(coord)

        directions = get_directions(*coord)
        for dir in directions:
            search(*dir, heights[row][col], visited, flowed)


    for row in range(len(heights)):
        for col in range(len(heights[0])):
            visited = set()
            flowed = {"p": False, "a": False}
            print(f"::: {row=}, {col=} :::")

            search(row, col, heights[row][col], visited, flowed)
            if flowed["p"] and flowed["a"]:
                result.append((row, col))
            print()

    print(result)
    return result


if __name__ == "__main__":
    h = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
    pacific_atlantic(h)

