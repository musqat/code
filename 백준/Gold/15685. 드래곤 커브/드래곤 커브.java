
import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] board = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragon(x, y, d, g);
        }

        int answer = 0;
        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                if (board[r][c] && board[r][c + 1] && board[r + 1][c] && board[r + 1][c + 1]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }


    static void dragon(int startX, int startY, int d, int g) {
        ArrayList<Integer> dirs = new ArrayList<>();
        dirs.add(d);

        for (int gen = 1; gen <= g; gen++) {
            int curSize = dirs.size();
            for (int i = curSize - 1; i >= 0; i--) {
                dirs.add((dirs.get(i) + 1) % 4);
            }
        }

        int x = startX;
        int y = startY;
        board[y][x] = true;

        for (int dir : dirs) {
            x += dx[dir];
            y += dy[dir];

            if (x >= 0 && x <= 100 && y >= 0 && y <= 100) {
                board[y][x] = true;
            }
        }

    }
}