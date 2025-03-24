import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static javax.swing.text.html.HTML.Attribute.N;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 친구 관계 수

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

//        for (int i = 1; i <= n; i++) {
//            System.out.println(i + " : " + graph.get(i));
//        }
        int minSum = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 1; i <= n; i++) {
            int[] dist = new int[n + 1];
            boolean[] visited = new boolean[n + 1];

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next : graph.get(cur)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        dist[next] = dist[cur] + 1;
                        queue.offer(next);
                    }
                }
            }
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += dist[j];
            }

            if (sum < minSum) {
                minSum = sum;
                result = i;
            }

        }

        System.out.println(result);
    }

}
