import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    static int bfs(int sx, int sy) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        int maxDist = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            maxDist = Math.max(maxDist, dist);

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 | nx >= N || ny >= M) continue;
                if (!visited[nx][ny] && map[nx][ny] == 'L'){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, dist+1});
                }

            }
        }
        return maxDist;
    }
}