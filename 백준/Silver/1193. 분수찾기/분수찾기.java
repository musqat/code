import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int line = 1;

        while (N > line) {
            N -= line;
            line++;
        }

        int x, y;
        if (line % 2 == 0) {
            x = N;
            y = line - N + 1;
        } else {
            x = line - N + 1;
            y = N;
        }

        System.out.println(x + "/" + y);
    }
}
