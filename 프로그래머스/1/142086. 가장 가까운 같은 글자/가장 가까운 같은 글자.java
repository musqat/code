import java.util.*;

class Solution {
    public int[] solution(String s) {
        int n = s.length();
        int[] answer = new int[n];

        HashMap<Character, Integer> hs = new HashMap<>();


        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (!hs.containsKey(c)) {
                answer[i] = -1;
            } else {
                answer[i] = i - hs.get(c);
            }

            hs.put(c, i);
        }

        return answer;
    }
}