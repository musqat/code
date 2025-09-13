import java.io.*;
import java.util.*;

public class Main {
    static int[][] points;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int nodeCount = N + 2;
            points = new int[nodeCount][2];

            for (int i = 0; i < nodeCount; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            System.out.println(bfs(nodeCount) ? "happy" : "sad");

        }

    }

    static boolean bfs(int nodeCount) {
        boolean[] visited = new boolean[nodeCount];
        Queue<Integer> q = new ArrayDeque<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == nodeCount - 1) return true;

            for (int i = 0; i < nodeCount; i++) {
                if (!visited[i] && distance(points[cur], points[i]) <= 1000) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return false;
    }

    static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
