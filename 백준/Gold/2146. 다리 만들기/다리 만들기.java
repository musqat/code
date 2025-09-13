
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] grid;
    static int[][] island;
    static boolean[][] visitIsland;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<List<int[]>> coasts = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        island = new int[N][N];
        visitIsland = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = countIsland();

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= K; i++) {
            answer = Math.min(answer, islandBfs(i));
            if (answer == 1) break;
        }

        System.out.println(answer);
    }

    static int countIsland() {
        int id = 0;
        coasts.add(new ArrayList<>());
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1 && !visitIsland[r][c]) {
                    id++;
                    coasts.add(new ArrayList<>());
                    groundBfs(r, c, id);
                }

            }
        }
        return id;

    }

    static void groundBfs(int sr, int sc, int id) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        visitIsland[sr][sc] = true;
        island[sr][sc] = id;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            boolean isCoast = false;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (!in(nr, nc)) continue;
                if (grid[nr][nc] == 1 && !visitIsland[nr][nc]) {
                    visitIsland[nr][nc] = true;
                    island[nr][nc] = id;
                    q.add(new int[]{nr, nc});
                }

                if (grid[nr][nc] == 0) {
                    isCoast = true;
                }
            }
            if (isCoast) coasts.get(id).add(new int[]{r, c});

        }
    }

    static int islandBfs(int id) {
        int[][] distSea = new int[N][N];
        for (int[] row : distSea) Arrays.fill(row, -1);
        Queue<int[]> q = new ArrayDeque<>();

        for (int[] cell : coasts.get(id)) {
            int r = cell[0], c = cell[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (!in(nr, nc)) continue;
                if (grid[nr][nc] == 0 && distSea[nr][nc] == -1) {
                    distSea[nr][nc] = 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        int best = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (!in(nr, nc)) continue;

                if (grid[nr][nc] == 0) {
                    if (distSea[nr][nc] == -1) {
                        distSea[nr][nc] = distSea[r][c] + 1;
                        q.add(new int[]{nr, nc});
                    }
                } else {
                    int other = island[nr][nc];
                    if (other > 0 && other != id) {
                        best = Math.min(best, distSea[r][c]);
                    }
                }

            }
        }
        return best;
    }

    static boolean in(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;

    }

}
