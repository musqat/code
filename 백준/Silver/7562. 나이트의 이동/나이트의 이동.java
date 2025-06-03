import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(bfs(n, x1, y1, x2, y2));

        }

    }


    static int bfs(int n, int x1, int y1, int x2, int y2) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x1,y1,0});
        visited[x1][y1] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y= cur[1], cnt = cur[2];
            if (x == x2 && y == y2){
                return cnt;
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny, cnt + 1});
                }

            }
        }
        return -1;
    }
}
