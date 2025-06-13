import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        divide(0, 0, n);

        System.out.println(sb);
    }

    public static void divide(int x, int y, int size) {
        if (isSame(x, y, size)) {
            sb.append(board[x][y]);
            return;
        }

        sb.append("(");

        int newSize = size / 2;

        divide(x, y, newSize);
        divide(x, y + newSize, newSize);
        divide(x + newSize, y, newSize);
        divide(x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    public static boolean isSame(int x, int y, int size) {
        int value = board[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != value) return false;
            }
        }
        return true;
    }
}
