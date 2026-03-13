import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] population = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) population[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph[i].add(next);
            }
        }

        for (int mask = 1; mask < (1 << N) - 1; mask++) {
            if (isConnected(mask, true) && isConnected(mask, false)) {
                int sumA = 0, sumB = 0;
                for (int i = 1; i <= N; i++) {
                    if (((mask >> (i - 1)) & 1) == 1) sumA += population[i];
                    else sumB += population[i];
                }
                min = Math.min(min, Math.abs(sumA - sumB));
            }

        }
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }

    static boolean isConnected(int mask, boolean isA) {
        List<Integer> group = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (isA) {
                if (((mask >> (i - 1)) & 1) == 1) group.add(i);
            } else {
                if (((mask >> (i - 1)) & 1) == 0) group.add(i);
            }
        }
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(group.get(0));
        visited[group.get(0)] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next] && group.contains(next)) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        for (int node : group) {
            if (!visited[node]) return false;
        }
        return true;

    }
}
