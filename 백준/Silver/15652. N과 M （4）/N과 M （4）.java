import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        dfs(1, N, M, new int[M], 0);
    }

    static void dfs(int start, int N, int M, int[] select, int depth){
        if (depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(select[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            select[depth] = i;
            dfs(i, N, M, select, depth + 1);
        }
    }


}
