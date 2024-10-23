import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] grid;
    static int[][] distance;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j) - '0';
                distance[i][j] = 0;
            }
        }
        int result = bfs(0, 0);

        System.out.println(result);
    }

    public static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        distance[startX][startY] = 1;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == N - 1 && y == M - 1) {
                return distance[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (grid[nx][ny] == 1 && distance[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        distance[nx][ny] = distance[x][y] + 1;
                    }
                }
            }
        }
        return -1;

    }
}
