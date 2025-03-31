import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][][] board;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        board = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    board[h][n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(bfs(board, M, N, H));

    }

    static int bfs(int[][][] board, int M, int N, int H) {
        Queue<int[]> queue = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (board[h][n][m] == 1) {
                        queue.offer(new int[]{h, n, m});
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M) {
                    continue;
                }

                if (board[nz][ny][nx] == 0) {
                    board[nz][ny][nx] = board[z][y][x] + 1;
                    queue.offer(new int[]{nz, ny, nx});
                }

            }

        }
        int max = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (board[h][n][m] == 0) {
                        return -1;
                    }
                    max = Math.max(max, board[h][n][m]);
                }
            }
        }

        return max - 1;
    }
}
