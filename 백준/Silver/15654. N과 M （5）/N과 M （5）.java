import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        seq(arr,m);
    }

    public static void seq(int[] arr, int m){
        Arrays.sort(arr);
        boolean[] visited = new boolean[arr.length];
        List<Integer> result = new ArrayList<>();
        dfs(arr, visited, result, m);

    }

    public static void dfs(int[] arr, boolean[] visited, List<Integer> result, int m){
        if (result.size() == m){
            StringBuilder sb = new StringBuilder();
            for (int num : result) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        int prev = -1;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]){
                continue;
            }
            if (prev == arr[i]){
                continue;
            }

            visited[i] = true;
            result.add(arr[i]);
            dfs(arr,visited, result, m);
            result.remove(result.size() -1);
            visited[i] = false;

            prev = arr[i];
        }
    }
}
