import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(br.readLine());

        isPrime(n);
        List<Integer> primeList = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (!prime[i]) primeList.add(i);
        }

        int left = 0, right = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= n) {
                sum -= primeList.get(left++);
            } else if (right == primeList.size()) {
                break;
            } else {
                sum += primeList.get(right++);
            }

            if (sum == n) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void isPrime(int N) {
        prime = new boolean[N + 1];
        if (N < 2) {
            return;
        }

        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
}
