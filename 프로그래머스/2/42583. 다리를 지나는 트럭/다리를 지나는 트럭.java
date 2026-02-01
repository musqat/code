import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int idx = 0;
        int curWeight = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }


        while (idx < truck_weights.length || !queue.isEmpty()) {
            time++;
            int out = queue.poll();
            curWeight -= out;

            if (idx < truck_weights.length && (curWeight + truck_weights[idx]) <= weight) {
                queue.add(truck_weights[idx]);
                curWeight += truck_weights[idx];
                idx++;
            } else if (idx < truck_weights.length){
                queue.add(0);
            }


        }


        return time;
    }
}