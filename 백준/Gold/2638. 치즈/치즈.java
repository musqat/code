import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;

        while (meltCheese()) {
            time++;
        }
        System.out.println(time);
    }

    public static boolean meltCheese() {
        visited = new boolean[N][M];
        List<int[]> meltList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;


                if (!visited[nx][ny] && board[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                } else if (board[nx][ny] == 1) {
                    int air = 0;
                    for (int d = 0; d < 4; d++) {
                        int ax = nx + dx[d];
                        int ay = ny + dy[d];

                        if (ax >= 0 && ay >= 0 && ax < N && ay < M && visited[ax][ay] && board[ax][ay] == 0) {
                            air++;
                        }
                    }
                    if (air >= 2) {
                        meltList.add(new int[]{nx, ny});
                    }
                }

            }
        }
        if (meltList.isEmpty()) return false;

        for (int[] pos : meltList) {
            board[pos[0]][pos[1]] = 0;
        }

        return true;
    }
}