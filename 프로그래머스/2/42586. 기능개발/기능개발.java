import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        List<Integer> days = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            days.add(day);
        }
        
        int base = days.get(0);
        int count = 1;

        for (int i = 1; i < len; i++) {
            if (days.get(i) <= base) {
                count++;
            } else {
                list.add(count);
                base = days.get(i);
                count = 1;
            }
        }
        list.add(count);


        return list.stream().mapToInt(i -> i).toArray();
    }
}