import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int N, M;
    static char[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        int[] red = new int[2];
        int[] blue = new int[2];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                    board[i][j] = '.';
                }
            }
        }

        bfs(red[0], red[1], blue[0], blue[1]);

    }

    static void bfs(int rx, int ry, int bx, int by) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        queue.offer(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int crx = cur[0], cry = cur[1];
            int cbx = cur[2], cby = cur[3];
            int depth = cur[4];

            if (depth >= 10) continue;

            for (int d = 0; d < 4; d++) {
                int[] nRed = move(crx, cry, dx[d], dy[d]);
                int[] nBlue = move(cbx, cby, dx[d], dy[d]);


                if (board[nBlue[0]][nBlue[1]] == 'O') continue;
                if (board[nRed[0]][nRed[1]] == 'O') {
                    System.out.println(depth + 1);
                    return;
                }

                if (nRed[0] == nBlue[0] && nRed[1] == nBlue[1]) {
                    if (nRed[2] > nBlue[2]) {
                        nRed[0] -= dx[d];
                        nRed[1] -= dy[d];
                    } else {
                        nBlue[0] -= dx[d];
                        nBlue[1] -= dy[d];
                    }
                }

                if (!visited[nRed[0]][nRed[1]][nBlue[0]][nBlue[1]]) {
                    visited[nRed[0]][nRed[1]][nBlue[0]][nBlue[1]] = true;
                    queue.offer(new int[]{nRed[0], nRed[1], nBlue[0], nBlue[1], depth + 1});
                }
            }
        }

        System.out.println(-1);
    }

    static int[] move(int x, int y, int dx, int dy) {
        int cnt = 0;
        while (board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            x += dx;
            y += dy;
            cnt++;
        }
        return new int[]{x, y, cnt};
    }
}


