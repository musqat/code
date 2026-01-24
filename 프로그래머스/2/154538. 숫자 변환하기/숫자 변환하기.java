import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.offer(new int[]{x, 0});
        visited.add(x);
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int num = cur[0];
            int cnt = cur[1];
            
            int[] next = {num + n, num * 2, num * 3};
            
            for (int nxt : next){
                if (nxt == y) return cnt + 1;
                
                if (nxt < y && !visited.contains(nxt)){
                    visited.add(nxt);
                    q.offer(new int[]{nxt, cnt + 1});
                }
                
                
            }
        }

        return -1;
    }



}