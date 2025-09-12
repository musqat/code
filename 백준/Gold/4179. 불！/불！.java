import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] fireDist;
    static int[][] jihunDist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireDist = new int[R][C];
        jihunDist = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireDist[i], -1);
            Arrays.fill(jihunDist[i], -1);
        }

        Queue<int[]> fireQ = new ArrayDeque<>();
        Queue<int[]> jihunQ = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});
                    fireDist[i][j] = 0;
                }
                if (map[i][j] == 'J') {
                    jihunQ.add(new int[]{i, j});
                    jihunDist[i][j] = 0;
                }
            }
        }

        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dr[d], ny = y + dc[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == '#') continue;
                if (fireDist[nx][ny] != -1) continue;
                fireDist[nx][ny] = fireDist[x][y] + 1;
                fireQ.add(new int[]{nx, ny});
            }
        }

        while (!jihunQ.isEmpty()) {
            int[] cur = jihunQ.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
                System.out.println(jihunDist[x][y] + 1);
                return;
            }


            for (int d = 0; d < 4; d++) {
                int nx = x + dr[d], ny = y + dc[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == '#') continue;
                if (jihunDist[nx][ny] != -1) continue;

                int nextTime = jihunDist[x][y] + 1;

                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= nextTime) continue;

                jihunDist[nx][ny] = nextTime;
                jihunQ.add(new int[]{nx,ny});
            }
        }


        System.out.println("IMPOSSIBLE");
    }
}
