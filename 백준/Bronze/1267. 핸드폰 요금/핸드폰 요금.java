import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int Y = 0;
        int M = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            Y += (t / 30 + 1) * 10;
            M += (t / 60 + 1) * 15;
        }

        if (Y < M) {
            System.out.println("Y " + Y);
        } else if (M < Y) {
            System.out.println("M " + M);
        } else {
            System.out.println("Y M " + Y);
        }
    }
}