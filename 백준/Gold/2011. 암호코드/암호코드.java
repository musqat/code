import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int len = line.length();
        int[] dp = new int[len + 1];

        dp[0] = 1;
        dp[1] = (line.charAt(0) != '0') ? 1 : 0;


        for (int i = 2; i <= len; i++) {
            int one = line.charAt(i - 1) - '0';
            if (one >= 1) dp[i] += dp[i - 1] %MOD;

            int two = (line.charAt(i-2) - '0') * 10 + (line.charAt(i-1) - '0');
            if (two >= 10 && two <= 26) dp[i] += dp[i-2] % MOD;

            dp[i] %= MOD;
        }


        System.out.println(dp[len] % MOD);

    }
}
