import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final long MOD = 1000000007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        System.out.println(fibo(n));
    }

    static long fibo(long n) {
        if (n == 0) {
            return 0;
        }
        long[] res = fastFibo(n);
        return res[0];
    }

    static long[] fastFibo(long n) {
        if (n == 0) {
            return new long[]{0, 1};
        }
        long[] half = fastFibo(n / 2);
        long a = half[0];
        long b = half[1];
        long c = (a * ((2 * b % MOD - a + MOD) % MOD)) % MOD;
        long d = (a * a % MOD + b * b % MOD) % MOD;
        if (n % 2 == 0){
            return new long[]{c,d};
        }else {
            return new long[]{d, (c + d ) % MOD};
        }

    }
}
