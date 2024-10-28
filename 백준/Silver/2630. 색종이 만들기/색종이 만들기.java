import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] grid;
    static int whiteCount = 0;
    static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divideAndConquer(0, 0, N);
        System.out.println(whiteCount);
        System.out.println(blueCount);

    }
    static void divideAndConquer(int x, int y, int size) {
        if (isUniform(x, y, size)) {
            if (grid[x][y] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }

        int newSize = size / 2;
        divideAndConquer(x, y, newSize);
        divideAndConquer(x, y + newSize, newSize);
        divideAndConquer(x + newSize, y, newSize);
        divideAndConquer(x + newSize, y + newSize, newSize);
    }
    static boolean isUniform(int x, int y, int size) {
        int firstColor = grid[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (grid[i][j] != firstColor) {
                    return false;
                }
            }
        }
        return true;
    }

}