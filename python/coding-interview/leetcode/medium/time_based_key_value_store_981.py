from collections import defaultdict


class TimeMap:

    def __init__(self):
        self.dict_list = defaultdict(list)
        self.dict_value = defaultdict(dict)

    def set(self, key, value, timestamp):
        self.dict_list[key].append(timestamp)
        self.dict_value[key][timestamp] = value

    def get(self, key, timestamp):
        target_timestamp = self._get_timestamp(
            self.dict_list[key],
            timestamp,
        )
        res = self.dict_value[key].get(target_timestamp)
        return res if res else "None"

    def _get_timestamp(self, timestamp_list, timestamp):
        if (not timestamp_list or
            timestamp < timestamp_list[0]):
            return None

        ret = timestamp_list[0]
        left, right = 0, len(timestamp_list)-1
        while left <= right:
            mid = (left+right) // 2
            if timestamp_list[mid] == timestamp:
                return timestamp_list[mid]
            elif timestamp_list[mid] > timestamp:
                ret = min(ret, timestamp_list[mid])
                right = mid-1
            else:
                ret = max(ret, timestamp_list[mid])
                left = mid+1

        return ret

if __name__ == "__main__":
    map = TimeMap()
    map.set("foo", "bar1", 1)
    print(map.get("foo", 1))
    print(map.get("foo", 3))

    map.set("foo", "bar2", 4)
    print(map.get("foo", 4))
    print(map.get("foo", 5))
    print(map.get("foo", 3))
