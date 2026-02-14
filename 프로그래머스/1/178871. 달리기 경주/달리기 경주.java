import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);

        }

        for (String t : callings){
            int idx = map.get(t);
            String tmp = players[idx - 1];
            
            players[idx - 1] = t;
            players[idx] = tmp;
            
            map.put(t, idx - 1);
            map.put(tmp, idx);
        }

        return players;
    }
}