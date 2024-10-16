import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] grid;
    static boolean[][] visited;
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            grid = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                grid[y][x] = 1;
            }


            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        bfs(j, i);
                        count++;
                    }
                }

            }
            System.out.println(count);

        }
        sc.close();
    }
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[y][x] = true;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N){
                    if (grid[ny][nx] == 1 && !visited[ny][nx]){
                        queue.add(new int[]{nx, ny});
                        visited[ny][nx] = true;
                    }
                }

            }
        }
    }
}
