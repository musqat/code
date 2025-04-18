import java.io.*;
import java.util.*;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int times = Integer.parseInt(st.nextToken());
        int over = Integer.parseInt(st.nextToken());

        dfs(1, arr[0], plus, minus, times, over);

        System.out.println(max);
        System.out.println(min);

    }


    static void dfs(int idx, int result, int plus, int minus, int times, int over) {
        if (idx == arr.length) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        if (plus > 0) {
            dfs(idx + 1, result + arr[idx], plus - 1, minus, times, over);
        }
        if (minus > 0) {
            dfs(idx + 1, result - arr[idx], plus, minus - 1, times, over);
        }
        if (times > 0) {
            dfs(idx + 1, result * arr[idx], plus, minus, times - 1, over);
        }
        if (over > 0) {
            int next = result < 0 ? -(-result / arr[idx]) : result / arr[idx];
            dfs(idx + 1, next, plus, minus, times, over - 1);
        }


    }
}
