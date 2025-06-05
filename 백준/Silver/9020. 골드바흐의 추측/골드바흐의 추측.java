import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        boolean[] isPrime = getPrime(10000);


        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = n / 2; j >= 2; j--) {
                if (isPrime[j] && isPrime[n- j]) {
                    System.out.println(j + " " + (n - j));
                    break;
                }

            }
        }
    }

    public static boolean[] getPrime(int N) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;

    }

}
