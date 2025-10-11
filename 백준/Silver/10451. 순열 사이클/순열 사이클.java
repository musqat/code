import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            int N = Integer.parseInt(br.readLine());

            int[] P = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                P[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[N + 1];
            int cycles = 0;

            for (int i = 1; i <= N; i++) {
                if (!visited[i]){
                    int cur = i;
                    while (!visited[cur]){
                        visited[cur] = true;
                        cur = P[cur];
                    }
                    cycles++;
                }
            }
            sb.append(cycles).append('\n');
        }
        System.out.println(sb);
    }
}