import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static final int INF = 16_000_000;
    static int N;
    static int[][] city;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        city = new int[N][N];
        dp = new int[N][1 << N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = TSP(0, 1);
        System.out.println(result);


    }

    static int TSP(int cur, int visited) {
        if (visited == (1 << N) - 1){
            return city[cur][0] == 0 ? INF : city[cur][0];
        }

        if (dp[cur][visited] != -1){
            return dp[cur][visited];
        }

        dp[cur][visited] = INF;

        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) == 0 && city[cur][next] != 0) {
                dp[cur][visited] = Math.min(dp[cur][visited], TSP(next, visited | (1 << next)) + city[cur][next]);
            }

        }

        return dp[cur][visited];
    }

}