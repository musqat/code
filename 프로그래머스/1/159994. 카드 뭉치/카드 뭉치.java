import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();

        q1.addAll(Arrays.asList(cards1));
        q2.addAll(Arrays.asList(cards2));


        for (int i = 0; i < goal.length ; i++) {

            if (!q1.isEmpty() && q1.peek().equals(goal[i])){
                q1.poll();
                continue;
            }

            if (!q2.isEmpty() && q2.peek().equals(goal[i])){
                q2.poll();
                continue;
            }
            return "No";
        }

        return "Yes";
    }
}