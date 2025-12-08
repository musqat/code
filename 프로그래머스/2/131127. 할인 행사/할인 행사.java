import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }


        for (int i = 0; i <= discount.length - 10; i++) {
            windowMap.clear();
            for (int j = i; j < i + 10; j++) {
                windowMap.put(discount[j], windowMap.getOrDefault(discount[j], 0) + 1);
            }

            if (wantMap.equals(windowMap)){
                answer++;
            }
        }


        return answer;
    }
}