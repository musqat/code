import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, M, D;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    int[][] clone = new int[N][M];
                    for (int r = 0; r < N; r++) {
                        clone[r] = map[r].clone();
                    }
                    bfs(clone, i, j, k);
                }
            }

        }
        System.out.println(result);

    }

    static void bfs(int[][] map, int archer1, int archer2, int archer3) {
        int count = 0;

        while (true) {
            boolean hasEnemy = false;
            for (int i = 0; i < N && !hasEnemy; i++) {
                for (int j = 0; j < M && !hasEnemy; j++) {
                    if (map[i][j] == 1) {
                        hasEnemy = true;
                    }
                }
            }
            if (!hasEnemy) break;

            int[] target1 = findTarget(map, archer1);
            int[] target2 = findTarget(map, archer2);
            int[] target3 = findTarget(map, archer3);

            Set<String> killed = new HashSet<>();
            int[][] targets = {target1, target2, target3};
            for (int[] t : targets) {
                if (t != null) {
                    String key = t[0] + "," + t[1];
                    if (killed.add(key)) {
                        count++;
                    }
                    map[t[0]][t[1]] = 0;
                }
            }

            for (int r = N - 1; r >= 0; r--) {
                for (int c = 0; c < M; c++) {
                    if (r == N - 1){
                        map[r][c] = 0;
                    }else {
                        map[r + 1][c] = map[r][c];
                        map[r][c] = 0;
                    }
                }

            }
        }

        result = Math.max(result, count);
    }


    static int[] findTarget(int[][] map, int col) {
        int minDist = Integer.MAX_VALUE;
        int targetR = -1, targetC = -1;

        for (int r = N - 1; r >= 0; r--) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1) {
                    int dist = (N - r) + Math.abs(c - col);

                    if (dist <= D && (dist < minDist || (dist == minDist && c < targetC))) {
                        minDist = dist;
                        targetR = r;
                        targetC = c;

                    }
                }
            }
        }
        if (targetR == -1) return null;

        return new int[]{targetR, targetC};
    }

}
