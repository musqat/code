
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());

            if (N <= 2) {
                sb.append(2).append('\n');
                continue;
            }

            long c = N;

            if (c % 2 == 0) c++;
            while (!isPrime(c)) c += 2;
            sb.append(c).append('\n');

        }
        System.out.println(sb);

    }

    static boolean isPrime(long n){
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;
        if (n % 3 == 0) return false;

        for (int i = 5; i <= n/i; i+=6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}