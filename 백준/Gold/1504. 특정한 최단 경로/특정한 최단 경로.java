import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static javax.swing.text.html.HTML.Attribute.N;

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
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static int[] path(int N, List<List<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.to;

            if (curNode.weight > dist[cur]) {
                continue;
            }

            for (Node adj : graph.get(cur)) {
                int newDist = dist[cur] + adj.weight;
                if (newDist < dist[adj.to]) {
                    dist[adj.to] = newDist;
                    pq.offer(new Node(adj.to, newDist));
                }
            }
        }
        return dist;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>(N + 1);


        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c)); // 양방향 그래프
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());


        int[] fromStart = path(N, graph, 1); // 출발점에서 모든 노드까지의 최단거리 배열
        int[] fromV1 = path(N, graph, v1); // v1에서 모든 노드까지의 최단거리 배열
        int[] fromV2 = path(N, graph, v2); // v2에서 모든 노드까지의 최단거리 배열

        // 1 -> v1 -> v2 -> N
        int path1 = (fromStart[v1] == Integer.MAX_VALUE || fromV1[v2] == Integer.MAX_VALUE || fromV2[N] == Integer.MAX_VALUE)
                ? Integer.MAX_VALUE
                : fromStart[v1] + fromV1[v2] + fromV2[N];

        // 1 → v2 → v1 → N
        int path2 = (fromStart[v2] == Integer.MAX_VALUE || fromV2[v1] == Integer.MAX_VALUE || fromV1[N] == Integer.MAX_VALUE)
                ? Integer.MAX_VALUE
                : fromStart[v2] + fromV2[v1] + fromV1[N];


        int result = Math.min(path1, path2);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

}
