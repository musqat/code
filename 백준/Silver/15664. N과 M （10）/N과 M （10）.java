import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                if (i > 0) sb.append(' ');
                sb.append(list.get(i));
            }
            sb.append('\n');
            return;
        }

        int prev = Integer.MIN_VALUE;
        for (int i = start; i < n; i++) {
            if (arr[i] == prev) continue;
            list.add(arr[i]);
            dfs(i + 1, depth + 1);
            list.remove(list.size() - 1);
            prev = arr[i];
        }
    }
}
