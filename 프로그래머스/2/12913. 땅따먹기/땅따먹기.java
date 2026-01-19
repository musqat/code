import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int len = land.length;
        int[][] dp = new int[len][4];

        dp[0] = land[0].clone();

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != j){
                        max = Math.max(max, dp[i-1][k]);
                    }
                }
                dp[i][j] = land[i][j] + max;
            }

        }
        return Arrays.stream(dp[land.length-1]).max().getAsInt();
    }
}