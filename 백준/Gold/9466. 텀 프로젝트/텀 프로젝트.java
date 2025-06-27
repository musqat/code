import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] graph;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            graph = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            System.out.println(N - count);
        }
    }

    static void dfs(int now){
        visited[now] = true;
        int next = graph[now];

        if (!visited[next]){
            dfs(next);
        }else if (!finished[next]){
            for (int i = next; i != now ; i = graph[i]) {
                count ++;
            }
            count++;
        }
        finished[now] = true;
    }
}
