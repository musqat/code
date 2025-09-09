import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long count5 = five(n) - five(n - m) - five(m);
        long count2 = two(n) - two(n - m) - two(m);

        System.out.println(Math.min(count5, count2));
    }

    static long five(long num) {
        int count = 0;
        while (num >= 5) {
            count += (int) (num / 5);
            num /= 5;
        }
        return count;
    }

    static long two(long num) {
        int count = 0;
        while (num >= 2) {
            count += (int) (num / 2);
            num /= 2;
        }
        return count;
    }
}
