import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];



        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(minDiff);

    }

    public static void dfs(int depth, int start) {
        if (depth == N / 2) {
            calDiff();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]){
                visited[i]  = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void calDiff(){
        int sTeam = 0;
        int lTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]){
                    sTeam += S[i][j];
                }else if (!visited[i] && !visited[j]){
                    lTeam += S[i][j];
                }
            }
        }
        int diff = Math.abs(sTeam - lTeam);
        minDiff = Math.min(minDiff, diff);

    }
}
