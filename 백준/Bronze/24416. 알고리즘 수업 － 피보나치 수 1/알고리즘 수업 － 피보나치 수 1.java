import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int count = 0;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        dp[1] = 1;
        dp[2] = 1;

        fibo(N);
        System.out.println(dp[N] + " " + count);

    }

    static int fibo(int n) {
        if (dp[n] != 0) return dp[n];

        count++;

        if (n <= 2) {
            dp[n] = 1;
        }
        return dp[n] = fibo(n - 1) + fibo(n - 2);
    }
}