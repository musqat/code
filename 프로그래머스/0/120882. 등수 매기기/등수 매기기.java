import java.util.Arrays;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] answer = new int[n];
        double[][] averages = new double[n][2];

        for (int i = 0; i < n; i++) {
            double avg = (score[i][0] + score[i][1]) / 2.0;
            averages[i][0] = avg;
            averages[i][1] = i;
        }

        Arrays.sort(averages, (a, b) -> Double.compare(b[0], a[0]));

        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && averages[i][0] == averages[i - 1][0]) {
                answer[(int) averages[i][1]] = rank;
            } else {
                rank = i + 1;
                answer[(int) averages[i][1]] = rank;
            }
        }

        return answer;
        
        
    }
}