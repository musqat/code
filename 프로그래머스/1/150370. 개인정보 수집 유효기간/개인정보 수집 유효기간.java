import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            String type = term[0];
            int time = Integer.parseInt(term[1]);
            map.put(type, time);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] pri = privacies[i].split(" ");
            if (calculate(today, pri[0], pri[1])){
                list.add(i + 1);
            };
        }
        return list.stream().mapToInt(x -> x).toArray();
    }


    private boolean calculate(String date, String day, String type) {
        int gap = map.get(type) * 28; // A -> 6;

        int today = toDays(date);
        int priday = toDays(day) + gap;

        return today >= priday; // 기간 만료
    }

    private int toDays(String d) {
        String[] date = d.split("\\.");
        return Integer.parseInt(date[0]) * 12 * 28
                + Integer.parseInt(date[1]) * 28
                + Integer.parseInt(date[2]);
    }

}