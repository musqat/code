import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> totalMap = new TreeMap<>();

        for (String record : records) {
            String[] tmp = record.split(" ");
            String[] timeArr = tmp[0].split(":");
            int time = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            String carNumber = tmp[1];
            String inOrout = tmp[2];


            if (inOrout.equals("IN")) {
                inMap.put(carNumber, time);
            } else if (inOrout.equals("OUT")) {
                totalMap.put(carNumber, totalMap.getOrDefault(carNumber, 0) + (time - inMap.get(carNumber)));
                inMap.remove(carNumber);
            }
        }

        for (Map.Entry<String, Integer> entry : inMap.entrySet()) {
            String carNumber = entry.getKey();
            totalMap.put(carNumber, totalMap.getOrDefault(carNumber, 0) + (1439 - entry.getValue()));

        }

        int[] result = new int[totalMap.size()];

        int idx = 0;
        for (Map.Entry<String, Integer> entry : totalMap.entrySet()) {
            if (entry.getValue() > fees[0]) {
                result[idx] += fees[1] + ((int) Math.ceil((double)(entry.getValue() - fees[0]) / fees[2])) * fees[3];
            } else {
                result[idx] += fees[1];
            }
            idx++;

        }

        return result;
    }
}