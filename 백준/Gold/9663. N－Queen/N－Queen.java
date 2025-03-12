import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] board;
    static int count = 0;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n];
        NQueen(0);
        System.out.println(count);
    }

    public static void NQueen(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                NQueen(row + 1);
            }

        }
    }

    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
