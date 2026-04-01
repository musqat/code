import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (points[i] >= points[i + 1]) {
                int newVal = points[i + 1] - 1;
                count += points[i] - newVal;
                points[i] = newVal;
            }

        }

        System.out.println(count);

    }
}
