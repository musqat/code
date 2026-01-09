import java.util.Arrays;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int idx = 0;
        
        for (int sec : section){
            if (sec > idx){
                answer++;
                idx = sec + m - 1;
            }
        }

        return answer;
    }
}