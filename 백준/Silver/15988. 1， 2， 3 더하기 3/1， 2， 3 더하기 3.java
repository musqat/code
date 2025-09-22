
import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = 0;

        int[] test = new int[T];

        for (int i = 0; i < T; i++) {
            test[i] = Integer.parseInt(br.readLine());
            if (test[i] > N) N = test[i];
        }

        long[] dp = new long[1_000_001];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;


        for (int i = 4; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        for (int t : test){
            System.out.println(dp[t]);
        }
    }

}