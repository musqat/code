import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());


        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs(A, B);
    }

    public static void bfs(int A, int B) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(A);
        visited[A] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        System.out.println(dist[B] == 0 ? -1 : dist[B]);
    }

}
