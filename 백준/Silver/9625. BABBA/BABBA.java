import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[46];
        int[] B = new int[46];

        A[0] = 1;
        B[0] = 0;

        for (int i = 0; i < N; i++) {
            A[i + 1] = B[i];
            B[i + 1] = B[i] + A[i];

        }

        System.out.println(A[N] + " " + B[N]);
    }
}
