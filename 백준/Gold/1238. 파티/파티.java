import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static int[] dijkstra(int v, List<List<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.to;

            if (curNode.weight > dist[cur]) continue;

            for (Node adj : graph.get(cur)) {
                if (dist[adj.to] > dist[cur] + adj.weight) {
                    dist[adj.to] = dist[cur] + adj.weight;
                    pq.offer(new Node(adj.to, dist[adj.to]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 마을 수
        int m = Integer.parseInt(st.nextToken()); // 도로 개수
        int x = Integer.parseInt(st.nextToken()); // 파티 마을

        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> reverseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            reverseGraph.get(b).add(new Node(a, c));
        }
        // x-> i (파티에서 집)
        int[] fromX = dijkstra(n, graph, x);

        // i -> x (집에서 파티)
        int[] toX = dijkstra(n, reverseGraph, x);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int total = toX[i] + fromX[i];
            max = Math.max(max, total);
        }

        System.out.println(max);


    }

}
