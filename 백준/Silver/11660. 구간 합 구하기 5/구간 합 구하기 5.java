import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // n x n
        int m = Integer.parseInt(st.nextToken()); // 합 횟수

        int[][] table = new int[n + 1][n + 1];
        prefixSum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = table[i][j]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = prefixSum[x2][y2]
                    - prefixSum[x1 - 1][y2]
                    - prefixSum[x2][y1 - 1]
                    + prefixSum[x1 - 1][y1 - 1];

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}
