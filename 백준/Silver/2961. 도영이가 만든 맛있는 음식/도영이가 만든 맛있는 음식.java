import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] S, B;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 1, false);
        System.out.println(ans);
    }

    static void dfs(int idx, long bitter, long sour, boolean picked) {
        if (idx == N) {
            if (picked) {
                ans = (int)Math.min(ans, Math.abs(sour - bitter));
            }
            return;
        }

        dfs(idx + 1, bitter + B[idx], sour * S[idx], true);
        dfs(idx + 1, bitter, sour, picked);
    }
}
