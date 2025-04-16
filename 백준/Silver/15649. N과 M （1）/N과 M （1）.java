import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] select;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        select = new int[M];
        visited = new boolean[N + 1];

        dfs(0);

    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(select[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                select[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
