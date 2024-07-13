#include <vector>

using std::min;
using std::max;
using std::vector;


class Solution{
public:
    int maxArea(vector<int>& height) {
        int maxArea = 0;

        int left = 0;
        int right = height.size()-1;

        while (left < right) {
            int currentArea = (right-left) * min(height.at(left), height.at(left));
            maxArea = max(maxArea, currentArea);

            if (height.at(left) > height.at(right)) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
};