import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int area;
    static int[][] board;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x] && board[y][x] == 0) {
                    area = 0;
                    dfs(y, x);
                    areas.add(area);
                }
            }
        }

        Collections.sort(areas);

        System.out.println(areas.size());
        for (int a : areas) {
            System.out.print(a + " ");
        }
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        area++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < M && nx >= 0 && nx < N) {
                if (!visited[ny][nx] && board[ny][nx] == 0) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
