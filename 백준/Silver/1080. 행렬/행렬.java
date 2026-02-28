import java.io.*;
import java.util.*;

public class Main {
    static int[][] diff;
    static int result = 0;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        diff = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = s.charAt(j) - '0';
            }
        }

        calDiff(A, B);

        filp();
        System.out.println(result);

    }

    private static void filp() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (diff[i][j] == 1) {
                    if (i + 2 > N - 1 || j + 2 > M - 1) {
                        result = -1;
                        return;
                    } else {
                        result++;
                        for (int k = 0; k < 3; k++) {
                            for (int l = 0; l < 3; l++) {
                                diff[i + k][j + l] ^= 1;
                            }
                        }

                    }
                }

            }

        }

    }

    private static void calDiff(int[][] A, int[][] B) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                diff[i][j] = A[i][j] ^ B[i][j];
            }
        }
    }
}