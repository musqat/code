import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] coin;
        int[] dp;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                coin[j] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];
            dp[0] = 1;

            for (int i = 0; i < N; i++) {
                for (int j = coin[i]; j < M + 1; j++) {
                    dp[j] = dp[j] + dp[j - coin[i]];
                }
            }

            System.out.println(dp[M]);
        }

    }
}
