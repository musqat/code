import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        String[][] types = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};

        for (int i = 0; i < survey.length; i++) {
            String[] str = survey[i].split("");
            int score = choices[i] - 4;
            if (score < 0) {
                map.merge(str[0], -score, Integer::sum);
            } else if (score > 0) {
                map.merge(str[1], score, Integer::sum);
            }
        }

        for (String[] pair : types){
            int left = map.getOrDefault(pair[0],0);
            int right = map.getOrDefault(pair[1],0);
            answer += (left >= right) ? pair[0] : pair[1];
        }
        return answer;
    }
}