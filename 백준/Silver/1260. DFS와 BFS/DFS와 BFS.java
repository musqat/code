import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n + 1];
        List<Integer> dfsList = new ArrayList<>();
        dfs(v, dfsList);
        printList(dfsList);
        
        visited = new boolean[n + 1];
        List<Integer> bfsList = bfs(v);
        printList(bfsList);
        
        sc.close();;
    }

    private static void dfs(int node, List<Integer> result){
        visited[node] = true;
        result.add(node);

        for (int next : graph.get(node)){
            if (!visited[next]){
                dfs(next, result);
            }
        }
    }

    private static List<Integer> bfs(int start){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for (int next : graph.get(node)){
                if (!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        return result;
    }

    private static void printList(List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            if (i > 0){
                System.out.print(" ");
            }
            System.out.print(list.get(i));
        }
        System.out.println();
    }
}
