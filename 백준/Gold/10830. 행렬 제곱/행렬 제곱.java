import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MOD = 1000;
    static int N;
    static long M;
    static int[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = power(origin, M);

        StringBuilder sb = new StringBuilder();
        for (int[] row : result){
            for (int val : row){
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static int[][] power(int[][] matrix, long exp) {
        if (exp == 1) {
            int[][] modded = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    modded[i][j] = matrix[i][j] % MOD;
                }
            }
            return modded;

        }

        int[][] half = power(matrix, exp / 2);
        int[][] result = multiply(half, half);

        if (exp % 2 == 1){
            result = multiply(result, origin);
        }

        return result;
    }

    static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum % MOD;
            }
        }
        return result;
    }
}
