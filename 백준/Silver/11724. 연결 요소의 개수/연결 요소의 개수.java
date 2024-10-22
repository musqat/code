import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[N + 1];
        int connect = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]){
                dfs(i);
                connect++;
            }
        }

        System.out.println(connect);
    }

    public static void dfs(int node){
        visited[node] = true;
        for (int neighbor : graph.get(node)){
            if (!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }

}
