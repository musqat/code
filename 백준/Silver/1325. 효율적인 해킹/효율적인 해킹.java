import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(B).add(A);
        }

        int[] cnt = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            cnt[i] = bfs(i);
            if (cnt[i] > max) max = cnt[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) if (cnt[i] == max) sb.append(i).append(' ');
        System.out.println(sb.toString().trim());
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);
        int count = 1;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    count++;
                }
            }
        }
        return count;
    }
}
