import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] isPrime = getPrime(N, M);

        int sum = 0;
        int min = -1;

        for (int i = 0; i <= M - N; i++) {
            if (isPrime[i] && (N + i) >= 2) {
                if (min == -1) min = N + i;
                sum += N + i;
            }
        }


        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    public static boolean[] getPrime(int N, int M) {
        boolean[] isPrime = new boolean[M - N + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= M; i++) {
            int start = Math.max(i * i, ((N + i - 1) / i) * i);
            for (int j = start; j <= M; j += i) {
                isPrime[j - N] = false;
            }
        }

        if (N == 0) isPrime[0] = false;
        if (N <= 1 && M >= 1) isPrime[1 - N] = false;

        return isPrime;
    }

}
