import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hour = 0;
        int lastMelt = 0;

        while (true) {
            visited = new boolean[N + 2][M + 2];
            List<int[]> melt = new ArrayList<>();

            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, 0});
            visited[0][0] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx > N + 1 || ny > M + 1) continue;
                    if (visited[nx][ny])continue;
                    
                    if (board[nx][ny] == 0){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }else if (board[nx][ny] == 1){
                        visited[nx][ny] = true;
                        melt.add(new int[]{nx,ny});
                    }
                }
            }

            if (melt.isEmpty()) {
                System.out.println(hour);
                System.out.println(lastMelt);
                return;
            }
            
            lastMelt = melt.size();
            for (int[] p : melt) board[p[0]][p[1]] = 0;
            hour++;
        }

    }
}