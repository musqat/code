import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int len = tangerine.length;
        List<Integer> list = new ArrayList<>();


        Arrays.sort(tangerine);

        int count = 1;

        for (int i = 1; i < len; i++) {
            if (tangerine[i] == tangerine[i - 1]) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);

        Collections.sort(list, Collections.reverseOrder());


        for (int o : list) {
            k -= o;
            answer++;
            if (k <= 0){
                return answer;
            }
        }

        return answer;
    }
}