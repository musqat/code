import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken()); // 총 층수
        int S = Integer.parseInt(st.nextToken()); // 시작
        int G = Integer.parseInt(st.nextToken()); // 목표
        int U = Integer.parseInt(st.nextToken()); // 위
        int D = Integer.parseInt(st.nextToken()); // 아래

        if (S == G){
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[F + 1];
        int[] dist = new int[F + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(S);
        visited[S] = true;
        dist[S] = 0;

        while (!q.isEmpty()){
            int cur = q.poll();

            int up = cur + U;
            if (U > 0 && up <= F && !visited[up]){
                visited[up] = true;
                dist[up] = dist[cur] + 1;
                if (up == G){
                    System.out.println(dist[up]);
                    return;
                }
                q.add(up);
            }

            int down = cur - D;
            if (D > 0 && down >= 1 && !visited[down]){
                visited[down] = true;
                dist[down] = dist[cur] + 1;
                if (down == G){
                    System.out.println(dist[down]);
                    return;
                }
                q.add(down);
            }

        }

        System.out.println("use the stairs");

    }
}
