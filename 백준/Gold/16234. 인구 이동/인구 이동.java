import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int N, MIN, MAX;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        MIN = Integer.parseInt(st.nextToken());
        MAX = Integer.parseInt(st.nextToken());


        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<Pos> union = new ArrayList();
                        dfs(i, j, union);

                        if (union.size() > 1) {
                            moved = true;
                            int sum = 0;
                            for (Pos p : union) sum += arr[p.x][p.y];
                            int avg = sum / union.size();
                            for (Pos p : union) arr[p.x][p.y] = avg;

                        }
                    }

                }
            }

            if (!moved) break;
            days++;
        }
        System.out.println(days);
    }

    static void dfs(int x, int y, List<Pos> union) {
        visited[x][y] = true;
        union.add(new Pos(x, y));

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                int diff = Math.abs(arr[x][y] - arr[nx][ny]);
                if (diff >= MIN && diff <= MAX) {
                    dfs(nx, ny, union);
                }


            }
        }

    }
}


