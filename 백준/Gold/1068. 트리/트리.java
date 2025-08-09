import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] children;
    static boolean[] visited;
    static int N, root, del, leafCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        children = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        root = -1;
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1){
                root = i;
            }else {
                children[p].add(i);
            }
        }

        del = Integer.parseInt(br.readLine());
        if (del == root){
            System.out.println(0);
            return;
        }

        visited = new boolean[N];
        dfs(root);
        System.out.println(leafCount);
    }

    static void dfs(int u) {
        if (u == del) return;
        visited[u] = true;

        int validChildren = 0;
        for (int v : children[u]) {
            if (v == del) continue;
            validChildren++;
            if (!visited[v]) dfs(v);
        }

        if (validChildren == 0) leafCount++;
    }
}
