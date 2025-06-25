import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges);
        parent = new int[N + 1];
        for (int i = 1; i < N; i++) {
            parent[i] = i;
        }

        int totalWeight = 0;
        int maxEdgeWeight = 0;

        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                totalWeight += edge.weight;
                maxEdgeWeight = edge.weight;
            }
        }
        System.out.println(totalWeight - maxEdgeWeight);


    }
}
