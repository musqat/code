import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  
        int[][] dp = new int[15][15];

        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i;
        }

        for (int k = 1; k <= 14; k++) {
            for (int n = 1; n <= 14; n++) {
                dp[k][n] = dp[k][n - 1] + dp[k - 1][n]; 
            }
        }

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());  
            System.out.println(dp[k][n]); 
        }
    }
}
