import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int maxSize = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    count++;
                    int size = bfs(i, j);
                    maxSize = Math.max(maxSize, size);
                }

            }

        }
        System.out.println(count);
        System.out.println(maxSize);
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y});
        int size = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if (board[nx][ny] == 1  && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        size++;
                    }
                }
            }
        }
        return size;
    }
}
