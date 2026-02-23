import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);

        System.out.println(count);
    }

    static void bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        dist[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)){
                if (dist[next] == -1) {

                    dist[next] = dist[cur] + 1;
                    if (dist[next] < 3) {
                        count++;
                        q.add(next);
                    }
                }
            }
        }
    }
}