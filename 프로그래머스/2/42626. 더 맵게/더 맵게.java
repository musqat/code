import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int scovilles : scoville) {
            pq.add(scovilles);
        }

        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            pq.add(pq.remove() + pq.remove() * 2);
        }

        return scoville.length - pq.size();
    }
}