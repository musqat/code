import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs();
    }


    private static void bfs() { // 정점, 간선, 시작
        int[] order = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();


        visited[R] = true;
        order[R] = 1;
        q.offer(R);
        int cnt = 2;


        while (!q.isEmpty()) {
            int cur = q.poll();
            Collections.sort(graph.get(cur));

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    order[next] = cnt++;
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }


}
