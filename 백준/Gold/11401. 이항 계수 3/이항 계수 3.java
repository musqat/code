import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007;
    static final int MAX = 4_000_001;
    static long[] dp = new long[MAX];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp[0] = 1;
        for (int i = 1; i < MAX ; i++) {
            dp[i] = dp[i - 1] * i % MOD;
        }

        if (K < 0 || K > N){
            System.out.println(0);
            return;
        }

        long result = dp[N] * modPow(dp[K], MOD - 2) % MOD * modPow(dp[N- K], MOD - 2) % MOD;

        System.out.println(result);
    }

    static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;

    }
}