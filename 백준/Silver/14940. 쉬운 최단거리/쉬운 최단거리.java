import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] grid, dist;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int targetX, targetY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                grid[i][j] = val;
                dist[i][j] = -1;
                if (val == 2) {
                    targetX = i;
                    targetY = j;
                }
            }
        }

        bfs(targetX, targetY);

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        dist[x][y] = 0;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curX = curr[0];
            int curY = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (grid[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[curX][curY] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && dist[i][j] == -1) {
                    dist[i][j] = -1;
                }
            }
        }
    }
}
