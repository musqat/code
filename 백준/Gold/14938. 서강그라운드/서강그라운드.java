import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v;
        int c;

        Node(int v, int c) {
            this.v = v;
            this.c = c;
        }


        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int N, M, R;
    static int[] items;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        items = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,l));
            graph.get(b).add(new Node(a,l));
        }


        int maxItems = 0;

        for (int i = 1; i <= N; i++) {
            int tmp = dijkstra(i);
            maxItems = Math.max(maxItems, tmp);
        }

        System.out.println(maxItems);
    }

    static int dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if (dist[cur.v] < cur.c) continue;

            for (Node next : graph.get(cur.v)){
                int nextDist = dist[cur.v] + next.c;

                if (nextDist < dist[next.v]){
                    dist[next.v] = nextDist;
                    pq.offer(new Node(next.v, nextDist));
                }
            }
        }

        int total = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= M){
                total += items[i];
            }
        }

        return total;



    }
}