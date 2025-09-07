import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX = 1_000_000;
    static boolean[] isPrime = new boolean[MAX + 1];

    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sieve();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            boolean found = false;
            for (int a = 3; a <= N / 2; a += 2) {
                if (isPrime[a] && isPrime[N - a]) {
                    sb.append(N).append(" = ").append(a).append(" + ").append(N - a).append('\n');
                    found = true;
                    break;
                }
            }

            if (!found) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }
        System.out.println(sb);

    }
}