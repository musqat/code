import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n +1 ];

        for (int i = 1; i < scores.length; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }


        int[] dp = new int[n+1];

        dp[1] = scores[1];
        if (n >= 2) {
            dp[2] = scores[1] + scores[2];
        }

        dp[0] = scores[0];
        dp[1] = scores[0] + scores[1];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + scores[i], dp[i - 3] + scores[i - 1] + scores[i]);
        }
        System.out.println(dp[n]);

    }

}
