import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dist;
    static int[] prev;
    static int[] depth;
    static List<List<Node>> graph = new ArrayList<>();

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(N, start);

        System.out.println(dist[end]);

        List<Integer> path = new ArrayList<>();

        int cur = end;
        while (cur != start) {
            path.add(cur);
            cur = prev[cur];
        }

        path.add(start);
        Collections.reverse(path);

        System.out.println(path.size());

        for (int city : path) {
            System.out.print(city + " ");
        }
    }

    public static void dijkstra(int N, int start) {
        dist = new int[N + 1];
        prev = new int[N + 1];
        depth = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        depth[start] = 1;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.to;

            if (curNode.weight > dist[cur]) {
                continue;
            }

            for (Node adj : graph.get(cur)) {
                int next = adj.to;
                int cost = dist[cur] + adj.weight;

                if (dist[next] > cost){
                    dist[next] = cost;
                    prev[next] = cur;
                    depth[next] = depth[cur] + 1;
                    pq.offer(new Node(next, dist[next]));
                }else if (dist[next] == cost && depth[next] > depth[cur] + 1 ){
                    prev[next] = cur;
                    depth[next] = depth[cur] + 1;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }
    }

}
