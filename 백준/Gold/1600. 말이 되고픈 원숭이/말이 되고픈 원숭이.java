
import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int r, c, k, d;

        Node(int r, int c, int k, int d) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.d = d;
        }
    }

    static final int[] dr4 = {-1, 1, 0, 0};
    static final int[] dc4 = {0, 0, -1, 1};

    static final int[] dr8 = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] dc8 = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] board = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (H == 1 && W == 1) {
            System.out.println(0);
            return;
        }

        boolean[][][] visited = new boolean[H][W][K + 1];
        ArrayDeque<Node> q = new ArrayDeque<>();
        visited[0][0][0] = true;
        q.offer(new Node(0, 0, 0, 0));

        int answer = -1;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr4[d];
                int nc = cur.c + dc4[d];

                if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if (board[nr][nc] == 1) continue;
                if (visited[nr][nc][cur.k]) continue;

                if (nr == H - 1 && nc == W - 1) {
                    answer = cur.d + 1;
                    System.out.println(answer);
                    return;
                }
                visited[nr][nc][cur.k] = true;
                q.offer(new Node(nr, nc, cur.k, cur.d + 1));
            }

            if (cur.k < K) {
                for (int d = 0; d < 8; d++) {
                    int nr = cur.r + dr8[d];
                    int nc = cur.c + dc8[d];
                    int nk = cur.k + 1;
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                    if (board[nr][nc] == 1) continue;
                    if (visited[nr][nc][nk]) continue;

                    if (nr == H - 1 && nc == W - 1){
                        answer = cur.d + 1;
                        System.out.println(answer);
                        return;
                    }
                    visited[nr][nc][nk] = true;
                    q.offer(new Node(nr, nc, nk, cur.d + 1));
                }
            }

        }
        System.out.println(answer);


    }
}