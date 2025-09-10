import java.io.*;
import java.util.*;

public class Main {
    static long[] S;
    static long sum(int i, int j) { return S[j] - S[i - 1]; }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            int[] a = new int[K + 1];
            int filled = 0;
            while (filled < K) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens() && filled < K) {
                    a[++filled] = Integer.parseInt(st.nextToken());
                }
            }

            S = new long[K + 1];
            for (int i = 1; i <= K; i++) S[i] = S[i - 1] + a[i];

            long[][] dp = new long[K + 2][K + 2];
            int[][] opt = new int[K + 2][K + 2];
            for (int i = 1; i <= K; i++) opt[i][i] = i;

            for (int len = 2; len <= K; len++) {
                for (int i = 1; i + len - 1 <= K; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Long.MAX_VALUE / 4;

                    int L = opt[i][j - 1];
                    int R = opt[i + 1][j];
                    for (int k = L; k <= R; k++) {
                        long cand = dp[i][k] + dp[k + 1][j] + sum(i, j);
                        if (cand < dp[i][j]) {
                            dp[i][j] = cand;
                            opt[i][j] = k;
                        }
                    }
                }
            }
            out.append(dp[1][K]).append('\n');
        }
        System.out.print(out);
    }
}
