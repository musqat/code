import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] board;
    static boolean[] visited = new boolean[26];
    static int max = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];


        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(max);
    }


    static void dfs(int x, int y, int depth) {
        visited[board[x][y] - 'A'] = true;

        max = Math.max(max, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                int idx = board[nx][ny] - 'A';
                if (!visited[idx]) {
                    dfs(nx, ny, depth + 1);
                }
            }

        }
        visited[board[x][y] - 'A'] = false;

    }
}
