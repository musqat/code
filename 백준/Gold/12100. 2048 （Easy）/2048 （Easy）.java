import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(max);
    }

    static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            for (int[] row : board) {
                for (int val : row) {
                    max = Math.max(max, val);
                }
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int[][] newBoard = move(d, board);
            dfs(depth + 1, newBoard);
        }
    }


    static int[] compress(int[] line) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int val : line) {
            if (val != 0) list.add(val);
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (!list.isEmpty()) {
            int a = list.poll();
            if (!list.isEmpty() && a == list.peek()) {
                result.add(a * 2);
                list.poll();
            } else {
                result.add(a);
            }
        }

        while (result.size() < N) result.add(0);
        return result.stream().mapToInt(i -> i).toArray();

    }

    static int[][] move(int dir, int[][] board) {
        int[][] newBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] line = new int[N];

            for (int j = 0; j < N; j++) {
                switch (dir) {
                    case 0:
                        line[j] = board[j][i];
                        break;
                    case 1:
                        line[j] = board[N - 1 - j][i];
                        break;
                    case 2:
                        line[j] = board[i][j];
                        break;
                    case 3:
                        line[j] = board[i][N - 1 - j];
                        break;
                }
            }

            int[] compressed = compress(line);

            for (int j = 0; j < N; j++) {
                switch (dir) {
                    case 0:
                        newBoard[j][i] = compressed[j];
                        break;
                    case 1:
                        newBoard[N - 1 - j][i] = compressed[j];
                        break;
                    case 2:
                        newBoard[i][j] = compressed[j];
                        break;
                    case 3:
                        newBoard[i][N - 1 - j] = compressed[j];
                        break;
                }
            }
        }
        return newBoard;

    }
}


