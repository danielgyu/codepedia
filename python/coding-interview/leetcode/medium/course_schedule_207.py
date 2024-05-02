def can_finish_course(visited, mapper, can_complete_courses, course):
    if course in visited:
        return False

    if course in can_complete_courses:
        return True

    visited = visited.copy()
    visited.add(course)
    pre_req_courses = mapper[course]
    for pre_req_course in pre_req_courses:
        if not can_finish_course(visited, mapper, can_complete_courses, pre_req_course):
            return False

    can_complete_courses.add(course)
    return True


def can_finish(num_courses, prerequisites):
    pre_req_by_course = [set() for _ in range(num_courses)]

    for prereq in prerequisites:
        target, req = prereq[0], prereq[1]
        pre_req_by_course[target].add(req)

    can_complete_courses = set()
    for course in range(num_courses):
        visited = set()
        if not can_finish_course(visited, pre_req_by_course, can_complete_courses, course):
            return False

    return True


if __name__ == "__main__":
    #print(can_finish(2, [[1, 0]]))
    #print(can_finish(2, [[1 ,0], [0, 1]]))
    #print(can_finish(4, [[1 ,0], [3, 1], [3, 2]]))
    #print(can_finish(5, [[1,4],[2,4],[3,1],[3,2]]))
    #print(can_finish(5, [[1, 0], [3, 1], [3, 2], [4, 3]]))
