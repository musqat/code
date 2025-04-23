import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (isValid(board[i])){
                result++;
            }
        }

        for (int i = 0; i < N; i++) {
            int[] col = new int[N];
            for (int j = 0; j < N; j++) {
                col[j] = board[j][i];
            }
            if (isValid(col)){
                result++;
            }

        }

        System.out.println(result);

    }

    public static boolean isValid(int[] line) {
        boolean[] used = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = line[i + 1] - line[i];
            if (diff == 0) {
                continue;
            } else if (diff == 1) {
                for (int j = 0; j < L; j++) {
                    int idx = i - j;
                    if (idx < 0 || line[idx] != line[i] || used[idx]) {
                        return false;
                    }
                    used[idx] = true;
                }
            } else if (diff == -1) {
                for (int j = 1; j <= L; j++) {
                    int idx = i + j;
                    if (idx >= N || line[idx] != line[i + 1] || used[idx]) {
                        return false;
                    }
                    used[idx] = true;

                }
            } else {
                return false;
            }

        }
        return true;
    }

}
