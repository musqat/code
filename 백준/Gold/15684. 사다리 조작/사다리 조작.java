
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static boolean[][] ladder;
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        for (int i = 0; i <= 3; i++) {
            found = false;
            dfs(1, 0, i);
            if (found){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    static void dfs(int idx, int placed, int limit){
        if (found) return;
        if (placed == limit){
            if (check()) found = true;
            return;
        }

        if (idx > H * (N - 1)) return;

        for (int i = idx; i <= H * (N - 1) ; i++) {
            int r = (i - 1 ) / (N - 1) + 1;
            int c = (i - 1) % (N - 1) + 1;

            if (canPlace(r,c)){
                ladder[r][c] = true;
                dfs(i + 1, placed + 1, limit);
                ladder[r][c] = false;
                if (found) return;
            }

        }

    }

    static boolean canPlace(int r, int c){
        if (ladder[r][c]) return false;
        if (c > 1 && ladder[r][c - 1]) return false;
        if (c < N - 1 && ladder[r][c + 1]) return false;
        return true;
    }

    static boolean check(){
        for (int start = 1; start <= N; start++) {
            int pos = start;
            for (int r = 1; r <= H ; r++) {
                if (pos <= N - 1 && ladder[r][pos]){
                    pos++;
                }else if (pos > 1 && ladder[r][pos - 1]){
                    pos--;
                }
            }
            if (pos != start) return false;
        }
        return true;
    }
}