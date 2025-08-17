import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Node  {
        int to;

        public Node(int to) {
            this.to = to;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        Deque<Integer> q = new ArrayDeque<>();
        dist[X] = 0;
        q.offer(X);


        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph.get(cur)){
                if (dist[nxt] != -1) continue;
                dist[nxt] = dist[cur] + 1;
                q.offer(nxt);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) sb.append(i).append('\n');
        }
        System.out.println(sb.length() == 0 ? "-1" : sb.toString());
    }
}
