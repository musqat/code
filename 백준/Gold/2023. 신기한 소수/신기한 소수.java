
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] starts = {2, 3, 5, 7};
        for (int s : starts) {
            dfs(s, 1);
        }

        System.out.println(sb);
    }

    static void dfs(int num, int len) {
        if (len == N) {
            sb.append(num).append('\n');
            return;
        }

        for (int d = 1; d <= 9; d += 2) {
            int next = num * 10 + d;
            if (isPrime(next)) {
                dfs(next, len + 1);
            }
        }
    }

    static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        int r = (int) Math.sqrt(x);
        for (int i = 3; i <= r; i += 2) {
            if (x % i == 0) return false;
        }

        return true;
    }
}