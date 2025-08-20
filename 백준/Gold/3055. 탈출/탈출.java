import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] waterTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        waterTime = new int[R][C];

        Queue<int[]> waterQueue = new LinkedList<>();
        int sx = 0, sy = 0;

        for (int i = 0; i < R; i++) {
            Arrays.fill(waterTime[i], Integer.MAX_VALUE);
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '*') {
                    waterQueue.offer(new int[]{i, j, 0});
                    waterTime[i][j] = 0;
                } else if (map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }

            }
        }

        while (!waterQueue.isEmpty()) {
            int[] cur = waterQueue.poll();
            int x = cur[0], y = cur[1], time = cur[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
                if (waterTime[nx][ny] <= time + 1) continue;

                waterTime[nx][ny] = time + 1;
                waterQueue.offer(new int[]{nx, ny, time + 1});

            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], time = cur[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (map[nx][ny] == 'X') continue;
                if (visited[nx][ny]) continue;

                if (map[nx][ny] == 'D'){
                    System.out.println(time + 1);
                    return;
                }

                if (time + 1 < waterTime[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, time + 1});
                }
            }
        }
        System.out.println("KAKTUS");
    }
}