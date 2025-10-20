import java.io.*;
import java.util.*;

public class Main {
    static int[][] bingo = new int[5][5];
    static boolean[][] check = new boolean[5][5];
    static int[][] pos = new int[26][2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int v = Integer.parseInt(st.nextToken());
                bingo[i][j] = v;
                pos[v][0] = i;
                pos[v][1] = j;
            }
        }

        int count = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int a = Integer.parseInt(st.nextToken());
                count++;
                marker(a);
                if (checkBingo() >= 3) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }


    static void marker(int a) {
        if (a >= 1 && a <= 25){
            int r = pos[a][0], c = pos[a][1];
            check[r][c] = true;
        }
    }

    static int checkBingo() {
        int lines = 0;

        // 가로
        for (int i = 0; i < 5; i++) {
            boolean ok = true;
            for (int j = 0; j < 5; j++) {
                if (!check[i][j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                lines++;
            }
        }

        // 세로
        for (int i = 0; i < 5; i++) {
            boolean ok = true;
            for (int j = 0; j < 5; j++) {
                if (!check[j][i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                lines++;
            }
        }

        // 대각선
        boolean d1 = true;
        for (int i = 0; i < 5; i++) {
            if (!check[i][i]){
                d1 = false;
                break;
            }
        }
        if (d1) lines++;

        //역 대각선
        boolean d2 = true;
        for (int i = 0; i < 5; i++) {
            if (!check[i][4 - i]) { d2 = false; break; }
        }
        if (d2) lines++;

        return lines;
    }
}