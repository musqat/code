import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] strArr) {
        int maxCount = 0;
        Map<Integer, Integer> lengthCount = new HashMap<>();

        for (String str : strArr) {
            int length = str.length();
            lengthCount.put(length, lengthCount.getOrDefault(length, 0) + 1);
        }

        for (int count : lengthCount.values()) {
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}