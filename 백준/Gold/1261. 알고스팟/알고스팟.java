import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] dist = new int[N][M];
        for (int[] row : dist) Arrays.fill(row, INF);

        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = 0;
        dq.addFirst(new int[]{0,0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int curX = x + dx[d];
                int curY = y + dy[d];

                if (curX < 0 || curX >= N || curY < 0 || curY >= M) continue;

                int w = board[curX][curY];
                int nd = dist[x][y] + w;
                if (nd < dist[curX][curY]){
                    dist[curX][curY] = nd;
                    if (w == 0) dq.addFirst(new int[]{curX, curY});
                    else dq.addLast(new int[]{curX, curY});

                }
            }
        }

        System.out.println(dist[N-1][M-1]);
    }
}