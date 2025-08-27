import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAX_SIZE = 100_001;
    static int time = 0;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N,K);

        System.out.println(time);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() -1) System.out.print(" ");
        }
    }

    static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX_SIZE];
        int[] parent = new int[MAX_SIZE];
        int[] dist = new int[MAX_SIZE];

        queue.offer(N);
        visited[N] = true;
        parent[N] = -1;
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                time = dist[K];

                List<Integer> path = new ArrayList<>();
                int current = K;
                while (current != -1){
                    path.add(current);
                    current = parent[current];
                }
                Collections.reverse(path);

                result = path;
                return;
            }

            int[] next = {cur - 1, cur + 1, cur * 2};

            for (int pos : next) {
                if (pos >= 0 && pos< MAX_SIZE &&!visited[pos]) {
                    visited[pos] = true;
                    parent[pos] = cur;
                    dist[pos] = dist[cur] + 1;
                    queue.offer(pos);
                }
            }


        }
    }
}