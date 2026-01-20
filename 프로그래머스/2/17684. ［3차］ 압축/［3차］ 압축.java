import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)('A' + i)), i + 1);
        }

        int nextNum = 27;


        String w = String.valueOf(msg.charAt(0));

        for (int i = 1; i < msg.length(); i++) {
            char c = msg.charAt(i);
            String wc = w + c;

            if (map.containsKey(wc)){
                w = wc;
            }else {
                list.add(map.get(w));
                map.put(wc, nextNum++);
                w = String.valueOf(c);
            }
        }
        list.add(map.get(w));
        
        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);

        }
        return answer;
    }
}