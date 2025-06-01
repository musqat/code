import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V;
    static ArrayList<Node>[] edges;
    static boolean[] visited;
    static int maxDist = 0;
    static int maxNode = 0;

    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());

        edges = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < V - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[from].add(new Node(to, weight));
            edges[to].add(new Node(from, weight));
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        maxDist = 0;
        dfs(maxNode, 0);

        System.out.println(maxDist);


    }

    public static void dfs(int node, int dist) {
        visited[node] = true;
        if (dist > maxDist) {
            maxDist = dist;
            maxNode = node;
        }
        for (Node edge : edges[node]) {
            if (!visited[edge.to]) {
                dfs(edge.to, dist + edge.weight);
            }

        }

    }

}
