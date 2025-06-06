import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static final int INF = 10000000;
    static List<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            edgeList = new ArrayList<>();

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(S, E, T));
                edgeList.add(new Edge(E, S, T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(S, E, -T));

            }

            boolean cycle = bellanFord(N, edgeList);
            System.out.println(cycle ? "YES" : "NO");
        }
    }

    static boolean bellanFord(int N, List<Edge> edges){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 0);

        for (int i = 1; i <= N; i++) {
            for(Edge e : edges){
                if (dist[e.to] > dist[e.from] + e.weight){
                    dist[e.to] = dist[e.from] + e.weight;
                    if (i == N) return true;
                }
            }

        }
        return false;

    }

}
