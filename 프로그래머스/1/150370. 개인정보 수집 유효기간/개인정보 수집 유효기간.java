import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String t : terms) {
            String[] part = t.split(" ");
            map.put(part[0], Integer.parseInt(part[1]));
        }
        int todayDays = dateToday(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] part = privacies[i].split(" ");
            String collectedDate = part[0];
            String termType = part[1];

            int expireDays = dateToday(collectedDate) + map.get(termType) * 28;

            if (todayDays >= expireDays) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dateToday(String d) {
        String[] part = d.split("\\.");
        return Integer.parseInt(part[0]) * 12 * 28
                + Integer.parseInt(part[1]) * 28
                + Integer.parseInt(part[2]);
    }

}