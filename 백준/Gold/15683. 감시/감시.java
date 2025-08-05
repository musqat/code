import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    static int[][][] directions = {
            {}, // 0번 없음
            {{0}, {1}, {2}, {3}}, // 1번
            {{0, 1}, {2, 3}}, // 2번
            {{0, 2}, {0, 3}, {1, 2}, {1, 3}}, // 3번
            {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}}, // 4번
            {{0, 1, 2, 3}} // 5번
    };
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<CCTV> cctvs = new ArrayList<>();
    static int minSpot = Integer.MAX_VALUE;

    static class CCTV {
        int x, y, type;

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (1<= board[i][j] && board[i][j] <= 5){
                    cctvs.add(new CCTV(i,j,board[i][j]));
                }
            }
        }

        dfs(0, board);
        System.out.println(minSpot);
    }

    static void watch(int[][] board, int x, int y, int dir) {
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (x < 0 || y < 0 || x >= N || y >= M || board[x][y] == 6) break;
            if (board[x][y] == 0) board[x][y] = 7;
        }
    }

    static void dfs(int depth, int[][] board) {
        if (depth == cctvs.size()) {
            minSpot = Math.min(minSpot, countSpot(board));
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int type = cctv.type;
        int x = cctv.x;
        int y = cctv.y;

        for (int[] dirs : directions[type]) {
            int[][] copied = copyMap(board);
            for (int dir : dirs) {
                watch(copied, x, y, dir);
            }
            dfs(depth + 1, copied);
        }
    }

    static int[][] copyMap(int[][] board) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, M);

        }
        return copy;
    }

    static int countSpot(int[][] board) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    count++;
                }

            }
        }
        return count;
    }

}
