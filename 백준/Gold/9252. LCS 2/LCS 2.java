import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp;
    static int aLen;
    static int bLen;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        aLen = A.length();
        bLen = B.length();

        LCS(A,B);
        LCSString(A, aLen, bLen);
        System.out.println(sb.toString());

    }

    static void LCS(String A, String B) {

        dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        sb.append(dp[aLen][bLen] + "\n");
    }

    static void LCSString(String A, int a, int b) {
        Stack<Character> st = new Stack<>();
        while (a > 0 && b > 0) {
            if (a == 0 || b == 0) break;

            if (dp[a][b] == dp[a - 1][b]) {
                a--;
            } else if (dp[a][b] == dp[a][b - 1]) {
                b--;
            } else {
                st.push(A.charAt(a - 1));
                a--;
                b--;
            }

        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
    }

}
