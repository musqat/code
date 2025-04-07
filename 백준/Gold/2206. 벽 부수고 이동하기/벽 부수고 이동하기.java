import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x, y, wall, dist;

        public Node(int x, int y, int wall, int dist) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);

    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 이동
                    if (board[nx][ny] == 0 && !visited[nx][ny][cur.wall]) {
                        visited[nx][ny][cur.wall] = true;
                        queue.add(new Node(nx, ny, cur.wall, cur.dist + 1));
                    }
                    // 벽일 경우 벽 부수고 이동
                    if (board[nx][ny] == 1 && cur.wall == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, 1, cur.dist + 1));
                    }
                }


            }
        }
        return -1;
    }
}
