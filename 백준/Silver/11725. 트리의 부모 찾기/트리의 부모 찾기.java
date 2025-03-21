import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static javax.swing.text.html.HTML.Attribute.N;

public class Main {
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        visited = new boolean[N + 1];


        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }


        dfs(1);
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int node){
        visited[node] = true;
        for (int next : tree.get(node)){
            if (!visited[next]){
                parent[next] = node;
                dfs(next);
            }
        }
    }

}
