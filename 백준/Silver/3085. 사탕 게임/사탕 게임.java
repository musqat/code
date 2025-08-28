import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int answer = 1;

        answer = Math.max(answer, check(arr));


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 좌우 스왑
                if (j + 1 < N && arr[i][j] != arr[i][j + 1]) {
                    swap(arr, i, j, i, j + 1);
                    answer = Math.max(answer, check(arr));
                    swap(arr, i, j, i, j + 1); // 되돌리기
                }

                // 상하 스왑
                if (i + 1 < N && arr[i][j] != arr[i + 1][j]) {
                    swap(arr, i, j, i + 1, j);
                    answer = Math.max(answer, check(arr));
                    swap(arr, i, j, i + 1, j); // 되돌리기
                }
            }

        }

        System.out.println(answer);
    }

    static int check(char[][] a) {
        int max = 1;

        // 행
        for (int i = 0; i < N; i++) {
            int run = 1;
            for (int j = 1; j < N; j++) {
                if (a[i][j] == a[i][j - 1]) run++;
                else run = 1;
                if (run > max) max = run;
            }
        }

        // 열
        for (int i = 0; i < N; i++) {
            int run = 1;
            for (int j = 1; j < N; j++) {
                if (a[j][i] == a[j - 1][i]) run++;
                else run = 1;
                if (run > max) max = run;
            }
        }

        return max;
    }

    static void swap(char[][] a, int r1, int c1, int r2, int c2) {
        char t = a[r1][c1];
        a[r1][c1] = a[r2][c2];
        a[r2][c2] = t;
    }
}