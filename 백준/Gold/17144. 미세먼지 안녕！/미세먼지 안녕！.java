import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int R, C, T;
    static int upper = -1, lower = -1;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == -1) {
                    if (upper == -1) upper = i;
                    else lower = i;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spread();
            cleaner();
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] > 0) result += board[i][j];
            }
        }

        System.out.println(result);
    }

    public static void spread() {
        int[][] tmp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] > 0) {
                    int amount = board[i][j] / 5;
                    int count = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = j + dx[d];
                        int ny = i + dy[d];

                        if (ny >= 0 && ny < R && nx >= 0 && nx < C && board[ny][nx] != -1) {
                            tmp[ny][nx] += amount;
                            count++;
                        }
                    }
                    tmp[i][j] += board[i][j] - (amount * count);
                } else if (board[i][j] == -1) {
                    tmp[i][j] = -1;
                }
            }

        }
        board = tmp;
    }

    static void cleaner(){
        for (int i = upper - 1; i > 0; i--) board[i][0] = board[i - 1][0];
        for (int j = 0; j < C - 1; j++) board[0][j] = board[0][j + 1];
        for (int i = 0; i < upper; i++) board[i][C - 1] = board[i + 1][C - 1];
        for (int j = C - 1; j > 1; j--) board[upper][j] = board[upper][j - 1];
        board[upper][1] = 0;

        for (int i = lower + 1; i < R - 1; i++) board[i][0] = board[i + 1][0];
        for (int j = 0; j < C - 1; j++) board[R - 1][j] = board[R - 1][j + 1];
        for (int i = R - 1; i > lower; i--) board[i][C - 1] = board[i - 1][C - 1];
        for (int j = C - 1; j > 1; j--) board[lower][j] = board[lower][j - 1];
        board[lower][1] = 0;

    }



}