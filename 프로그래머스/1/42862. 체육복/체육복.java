import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 2];
        Arrays.fill(students, 1);

        for (int l : lost){
            students[l]--;
        }

        for (int r : reserve){
            students[r]++;
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] >= 2){
                if (students[i - 1] == 0){
                    students[i -1]++;
                    students[i]--;
                }else if (students[i + 1] == 0){
                    students[i + 1]++;
                    students[i]--;
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >0) answer++;
        }
        
        return answer;


    }
}