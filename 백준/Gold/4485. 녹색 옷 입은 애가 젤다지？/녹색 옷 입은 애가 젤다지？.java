import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static final int INF = 1_000_000_000;

    static class Node implements Comparable<Node> {
        int r, c;
        int cost;


        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        while (true) {
            int T = Integer.parseInt(br.readLine());
            if (T == 0) break;

            int[][] board = new int[T][T];
            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < T; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dist = new int[T][T];
            for (int i = 0; i < T; i++) {
                Arrays.fill(dist[i], INF);
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            dist[0][0] = board[0][0];
            pq.add(new Node(0, 0, dist[0][0]));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (cur.cost > dist[cur.r][cur.c]) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (nr < 0 || nr >= T || nc < 0 || nc >= T) continue;

                    int newCost = cur.cost + board[nr][nc];

                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.add(new Node(nr, nc, newCost));
                    }
                }
            }
            System.out.println("Problem " + count++ + ": " + dist[T - 1][T - 1]);

        }
    }
}