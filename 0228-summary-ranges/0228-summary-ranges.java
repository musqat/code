import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) { // [0,1,2,4,5,7]
        List<String> result = new ArrayList<>();
        int start = 0; // idx
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i - 1] + 1 != nums[i] ) {
                result.add(start == i - 1 ? String.valueOf(nums[start]) : nums[start] + "->" + nums[i - 1]);
                start = i;
            }
        }

        return result;
    }
}