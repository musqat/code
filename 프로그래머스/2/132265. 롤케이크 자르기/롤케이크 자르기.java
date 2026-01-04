import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }


        for (int i = 0; i < topping.length; i++) {
            left.add(topping[i]);

            int count = right.get(topping[i]);
            if (count == 1){
                right.remove(topping[i]);
            }else {
                right.put(topping[i], count - 1);
            }

            if (left.size() == right.size()){
                answer++;
            }
        }


        return answer;
    }
}