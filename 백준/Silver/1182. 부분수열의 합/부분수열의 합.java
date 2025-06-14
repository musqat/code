import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, S, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,0);
        System.out.println(count);
    }

    public static void dfs(int idx, int sum, int selected){
        if (idx == N){
            if (sum == S && selected > 0){
                count++;
            }
            return;
        }
        dfs(idx + 1, sum + arr[idx] , selected + 1);

        dfs(idx + 1, sum, selected);
    }

}
