import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int len = progresses.length;

        List<Integer> days = new ArrayList<>();


        for (int i = 0; i < len; i++) {
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            days.add(day);
        }

        List<Integer> list = new ArrayList<>();
        
        int base = days.get(0);
        int count = 1;

        for (int i = 1; i < len; i++) {
            if (days.get(i) <= base){
                count++;
            }else {
                list.add(count);
                base = days.get(i);
                count = 1;
            }
        }
        list.add(count);
        
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}