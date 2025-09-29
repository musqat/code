
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }


        int maxArea = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int size = 0; i + size < n && j + size < m; size++) {
                    int a = arr[i][j];

                    if (a == arr[i][j + size] &&
                            a == arr[i + size][j] &&
                            a == arr[i + size][j + size]) {
                        int side = size + 1;
                        maxArea = Math.max(maxArea, side * side);
                    }
                }
            }

        }
        System.out.println(maxArea);

    }
}