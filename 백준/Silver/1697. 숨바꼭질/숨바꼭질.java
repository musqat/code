import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        queue.offer(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int time = current[1];

            if (pos == K) {
                System.out.println(time);
                return;
            }

            if (pos * 2 <= 100000 && !visited[pos * 2]) {
                queue.offer(new int[]{pos * 2, time + 1});
                visited[pos * 2] = true;
            }
            if (pos + 1 <= 100000 && !visited[pos + 1]) {
                queue.offer(new int[]{pos + 1 , time + 1});
                visited[pos + 1] = true;
            }
            if (pos - 1 >= 0 && !visited[pos  - 1]) {
                queue.offer(new int[]{pos - 1, time + 1});
                visited[pos - 1] = true;
            }
        }
    }
}
