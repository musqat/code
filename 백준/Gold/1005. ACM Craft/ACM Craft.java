import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] time = new int[N + 1];
            int[] indegree = new int[N + 1];
            List<Integer>[] graph = new ArrayList[N + 1];
            int[] dp = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                indegree[b]++;
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                dp[i] = time[i];
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }


            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int next : graph[now]) {
                    dp[next] = Math.max(dp[next], dp[now] + time[next]);
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }

            }

            int W = Integer.parseInt(br.readLine());
            System.out.println(dp[W]);

        }
    }
}
