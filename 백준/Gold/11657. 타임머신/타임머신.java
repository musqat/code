import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Edge> graph;
    static final int INF = 1000000000;

    static class Edge {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Edge(v, w, cost));
        }

        long[] dist = BellmanFord(N, graph, 1);

        if (dist == null) {
            System.out.println(-1);
            return;
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (dist[i] >= INF) {
                sb.append(-1).append('\n');
            } else {
                sb.append(dist[i]).append('\n');
            }
        }
        System.out.println(sb);
    }

    static long[] BellmanFord(int n, List<Edge> graph, int start) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 1; i <= n - 1; i++) {
            boolean update = false;
            for (Edge e : graph) {
                if (dist[e.from] == INF) continue;
                long nd = dist[e.from] + e.cost;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    update = true;
                }
            }
            if (!update) break;
        }

        for (Edge e : graph) {
            if (dist[e.from] == INF) continue;
            if (dist[e.from] + e.cost < dist[e.to]) {
                return null;
            }
        }
        return dist;
    }
}
