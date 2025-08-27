import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[] parent = new int[N + 1];

        dp[1] = 0;
        parent[1] = -1;
        
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            parent[i] = i - 1;

            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                parent[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                parent[i] = i / 3;
            }
        }

        System.out.println(dp[N]);


        List<Integer> path = new ArrayList<>();
        int current = N;
        while (current != -1) {
            path.add(current);
            current = parent[current];
        }

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" ");
        }
    }
}