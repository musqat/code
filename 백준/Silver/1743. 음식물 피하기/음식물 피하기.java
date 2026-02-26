import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0,};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        board = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x - 1][y - 1] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    count = Math.max(count, dfs(i, j));
                }
            }
        }

        System.out.println(count);

    }


    static int dfs(int x, int y) {

        visited[x][y] = true;
        int size = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    size += dfs(nx, ny);
                }
            }
        }
        return size;
    }
}