import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, X, Y;
    static int[][] board;
    // 0= index용 ,1=동, 2=서, 3=북, 4=남
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[] dice = new int[7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());

            dice(dir);
        }
    }

    static void rollDice(int dir) {
        int[] temp = dice.clone();

        switch (dir) {
            case 1:
                dice[1] = temp[4];
                dice[3] = temp[1];
                dice[6] = temp[3];
                dice[4] = temp[6];
                break;
            case 2:
                dice[1] = temp[3];
                dice[4] = temp[1];
                dice[6] = temp[4];
                dice[3] = temp[6];
                break;
            case 3:
                dice[1] = temp[5];
                dice[2] = temp[1];
                dice[6] = temp[2];
                dice[5] = temp[6];
                break;
            case 4:
                dice[1] = temp[2];
                dice[5] = temp[1];
                dice[6] = temp[5];
                dice[2] = temp[6];
                break;
        }
    }

    static void dice(int dir) {
        int nx = X + dx[dir];
        int ny = Y + dy[dir];


        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            rollDice(dir);

            if (board[nx][ny] == 0) {
                board[nx][ny] = dice[6];
            } else {
                dice[6] = board[nx][ny];
                board[nx][ny] = 0;
            }
            X = nx;
            Y = ny;
            System.out.println(dice[1]);

        }


    }
}
