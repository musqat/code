import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        Map<String, String> Enter = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");

            if (tmp[0].equals("Enter") || tmp[0].equals("Change")) {
                Enter.put(tmp[1], tmp[2]); 
            }
        }

        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");

            if (tmp[0].equals("Enter")){
                list.add(Enter.get(tmp[1]) + "님이 들어왔습니다.");
            }
            else if (tmp[0].equals("Leave")){
                list.add(Enter.get(tmp[1]) + "님이 나갔습니다.");
            }

        }
        
        return list.toArray(new String[0]);

    }
}