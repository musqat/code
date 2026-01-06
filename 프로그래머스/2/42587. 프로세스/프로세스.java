import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
            pq.offer(priorities[i]);
        }



        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int priority = cur[0];
            int origIdx = cur[1];

            if (priority < pq.peek()) {
                queue.offer(cur);
            }else {
                pq.poll();
                answer++;
                if (origIdx == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}