import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean found;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N];

        found = false;

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (found) break;
        }

        System.out.println(found ? 1 : 0);

    }

    static void dfs(int node, int depth){
        if (found) return;

        if (depth == 5){
            found = true;
            return;
        }

        visited[node] = true;

        for (int next : graph.get(node)){
            if (!visited[next]){
                dfs(next, depth + 1);
                if (found){
                    visited[node] = false;
                    return;
                }
            }
        }
        visited[node] = false;

    }
}