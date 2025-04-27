import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder.put(x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snake.put(u, v);
        }

        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];

        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int pos = now[0];
            int move = now[1];

            if (pos == 100) {
                System.out.println(move);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next > 100) {
                    continue;
                }

                if (ladder.containsKey(next)) {
                    next = ladder.get(next);
                } else if (snake.containsKey(next)) {
                    next = snake.get(next);
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, move + 1});
                }

            }
        }
    }
}
