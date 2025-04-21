import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int count = 0;

    static int[] dx = {-1, 0, 1, 0}; // 북동남서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(x, y, dir);
        System.out.println(count);

    }

    public static void clean(int x, int y, int dir) {
        while (true) {
            if (!visited[x][y]) {
                visited[x][y] = true;
                count++;
            }

            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (board[nx][ny] == 0 && !visited[nx][ny]) {
                        x = nx;
                        y = ny;
                        moved = true;
                        break;
                    }
                }
            }

            if (!moved) {
                int back = (dir + 2) % 4;
                int bx = x + dx[back];
                int by = y + dy[back];

                if (bx < 0 || bx >= N || by < 0 || by >= M || board[bx][by] == 1) {
                    break;
                }
                x = bx;
                y = by;
            }
        }
    }

}
