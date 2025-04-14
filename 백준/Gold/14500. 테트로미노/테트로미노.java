import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max = 0;
    static int[][] board;
    static boolean[][] visit;
    static int n, m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                tetris(i, j, board[i][j], 1);
                visit[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static void tetris(int x, int y, int sum, int count) {

        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (curX < 0 || curX >= n || curY < 0 || curY >= m) {
                continue;
            }

            if (!visit[curX][curY]) {
                if (count == 2) {
                    visit[curX][curY] = true;
                    tetris(x, y, sum + board[curX][curY], count + 1);
                    visit[curX][curY] = false;
                }

                visit[curX][curY] = true;
                tetris(curX, curY, sum + board[curX][curY], count + 1);
                visit[curX][curY] = false;
            }
        }
    }
}
