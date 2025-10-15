import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N + 1];
        int[] indeg = new int[N + 1];

        List<Integer>[] g = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int v = 1; v <= N; v++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[v] = Integer.parseInt(st.nextToken());
            while (true) {
                int p = Integer.parseInt(st.nextToken());
                if (p == -1) break;
                g[p].add(v);
                indeg[v]++;
            }
        }

        int[] dp = new int[N + 1];
        int[] acc = new int[N + 1];


        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int v = 1; v <= N; v++) {
            if (indeg[v] == 0){
                dp[v] = time[v];
                q.add(v);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]){
                if (acc[v] < dp[u]) acc[v] = dp[u];
                if (--indeg[v] == 0){
                    dp[v] = acc[v] + time[v];
                    q.add(v);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v = 1; v <= N; v++) {
            sb.append(dp[v]).append('\n');
        }
        System.out.println(sb);

    }
}