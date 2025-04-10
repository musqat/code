import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;


    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public int compareTo(Fish o) {
            if (this.dist == o.dist) {
                if (this.x == o.x)
                    return this.y - o.y;
                return this.x - o.x;
            }
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    startX = i;
                    startY = j;
                    board[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish target = bfs(startX, startY);
            if (target == null) {
                break;
            }

            time += target.dist;
            eatCount++;
            board[target.x][target.y] = 0;
            startX = target.x;
            startY = target.y;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);

    }

    static Fish bfs(int x, int y) {
        visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Fish> fishes = new PriorityQueue<>();

        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int dist = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (board[nx][ny] > sharkSize) {
                    continue;
                }

                visited[nx][ny] = true;

                if (board[nx][ny] != 0 && board[nx][ny] < sharkSize){
                    fishes.offer(new Fish(nx, ny, dist + 1));
                }

                queue.offer(new int[]{nx, ny, dist + 1});
            }

        }


        return fishes.isEmpty() ? null : fishes.poll();
    }

}
