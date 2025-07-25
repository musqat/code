import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        final int INF = 10001;
        int[] dp = new int[K + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int coin : arr) {
            for (int i = coin; i <= K; i++) {
                if (dp[i - coin] != INF) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[K] == INF ? -1 : dp[K]);
    }
}
