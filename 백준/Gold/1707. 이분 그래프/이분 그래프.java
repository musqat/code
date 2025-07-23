import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] color;
    static boolean isBipartite ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        while (K-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            color = new int[V + 1];
            isBipartite = true;

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for (int i = 1; i <= V; i++) {
                if (color[i] == 0){
                    bfs(i);
                }

            }
            System.out.println(isBipartite ? "YES" : "NO");

        }

    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1;

        while (!queue.isEmpty()){
            int now = queue.poll();

            for (int next : graph.get(now)){
                if (color[next] == 0){
                    color[next] = -color[now];
                    queue.offer(next);
                }else if (color[next] == color[now]){
                    isBipartite = false;
                    return;
                }
            }
        }


    }
}
