import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] x = new long[N];
        long[] y = new long[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        double area = 0;
        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N;
            area += (x[i]  * y[j]) - (x[j] * y[i]);
        }

        area = Math.abs(area) / 2.0;

        System.out.printf("%.1f\n", area);
    }

}
