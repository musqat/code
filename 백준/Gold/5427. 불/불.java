import java.io.*;
import java.util.*;

public class Main {
    static int N, W, H;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] building;
    static int[][] fireTime;
    static int[][] personTime;
    static Queue<Point> fireQueue;
    static Queue<Point> personQueue;

    static class Point {
        int x, y, time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int T = 0; T < N; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            building = new char[H][W];
            fireTime = new int[H][W];
            personTime = new int[H][W];

            for (int i = 0; i < H; i++) {
                Arrays.fill(fireTime[i], Integer.MAX_VALUE);
                Arrays.fill(personTime[i], -1);
            }


            fireQueue = new LinkedList<>();
            personQueue = new LinkedList<>();

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                building[i] = line.toCharArray();

                for (int j = 0; j < W; j++) {
                    if (building[i][j] == '@') {
                        personQueue.add(new Point(i, j, 0));
                        personTime[i][j] = 0;
                    }
                    if (building[i][j] == '*') {
                        fireQueue.add(new Point(i, j, 0));
                        fireTime[i][j] = 0;
                    }
                }
            }

            fireBFS();

            int result = personBFS();
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }

    static void fireBFS() {
        while (!fireQueue.isEmpty()) {
            Point cur = fireQueue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;

                if (building[nx][ny] == '#') continue;

                if (fireTime[nx][ny] != Integer.MAX_VALUE) continue;

                fireTime[nx][ny] = cur.time + 1;
                fireQueue.add(new Point(nx, ny, cur.time + 1));
            }
        }
    }

    static int personBFS() {
        while (!personQueue.isEmpty()) {
            Point cur = personQueue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                    return cur.time + 1;
                }

                if (building[nx][ny] == '#') continue;

                if (personTime[nx][ny] != -1) continue;

                if (fireTime[nx][ny] <= cur.time + 1) continue;

                personTime[nx][ny] = cur.time + 1;
                personQueue.add(new Point(nx, ny, cur.time + 1));
            }
        }
        return -1; // 탈출 실패
    }
}