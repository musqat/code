import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int maxDist = 0;
    static int farNode = 0;

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true){
                int v = Integer.parseInt(st.nextToken());
                if (v == -1){
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                graph.get(u).add(new Node(v, w));
            }
        }

        visited = new boolean[N + 1];
        dfs(1,0,graph);

        visited = new boolean[N + 1];
        maxDist = 0;
        dfs(farNode, 0, graph);
        System.out.println(maxDist);
    }

    public static void dfs(int node, int dist, List<List<Node>> graph){
        visited[node] = true;

        if (dist > maxDist){
            maxDist = dist;
            farNode = node;
        }

        for (Node next : graph.get(node)){
            if (!visited[next.to]){
                dfs(next.to, dist + next.weight , graph);
            }
        }

    }
}
