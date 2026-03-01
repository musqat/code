import java.io.*;
import java.util.*;

public class Main {
    static double[][] stars;

    static double dist(int a, int b) { // 거리 계산
        double dx = stars[a][0] - stars[b][0];
        double dy = stars[a][1] - stars[b][1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stars = new double[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        boolean[] visited = new boolean[N];
        double[] minDist = new double[N];
        Arrays.fill(minDist, Double.MAX_VALUE);
        minDist[0] = 0;
        double result = 0;

        for (int i = 0; i < N; i++) {
            int u = -1;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])){
                    u = j;
                }
            }

            visited[u] = true;
            result += minDist[u];

            for (int v = 0; v < N; v++) {
                if (!visited[v] && dist(u,v) < minDist[v]) {
                    minDist[v] = Math.min(minDist[v], dist(u, v));
                }
            }

        }

        System.out.printf("%.2f\n", result);
    }
}