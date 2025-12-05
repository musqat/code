import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for (int e : elements) list.add(e);
        for (int e : elements) list.add(e);

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = 1; j <= elements.length; j++) {
                sum += list.get(i + j - 1);
                set.add(sum);

            }

        }



        answer = set.size();
        return answer;
    }
}