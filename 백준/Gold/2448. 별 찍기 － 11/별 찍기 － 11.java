import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stars = new char[N][N * 2 - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(stars[i], ' ');
        }

        star(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void star(int r, int c, int N) {
        if (N == 3) {
            stars[r][c] = '*';
            stars[r + 1][c - 1] = stars[r + 1][c + 1] = '*';
            stars[r + 2][c - 2] = stars[r + 2][c - 1] = stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
            return;
        } else {
            int split = N / 2;
            star(r, c, split);
            star(r + split, c - split, split);
            star(r + split, c + split, split);
        }
    }
}


