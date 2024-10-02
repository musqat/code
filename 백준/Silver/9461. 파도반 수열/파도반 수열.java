import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] pado = new long[101];
        pado[1] = 1;
        pado[2] = 1;
        pado[3] = 1;
        pado[4] = 2;
        pado[5] = 2;

        for (int i = 6; i <= 100; i++) {
            pado[i] = pado[i - 1] + pado[i - 5];
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < n; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(pado[N]).append("\n");
        }

        System.out.print(sb);  
    }
}
