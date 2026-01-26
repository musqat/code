import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> minPress = new HashMap<>();


        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                minPress.put(c, Math.min(minPress.getOrDefault(c, Integer.MAX_VALUE), i + 1));
            }

        }

        for (int i = 0; i < targets.length; i++) {
            int totalPress = 0;
            
            for (char c : targets[i].toCharArray()){
                if (!minPress.containsKey(c)){
                    totalPress = -1;
                    break;
                }
                totalPress += minPress.get(c);
            }
            answer[i] = totalPress;

        }
        


        return answer;
    }
}