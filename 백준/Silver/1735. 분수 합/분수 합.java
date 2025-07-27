import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long c = Integer.parseInt(st.nextToken());
        long d = Integer.parseInt(st.nextToken());

        long numerator = a * d + b * c;
        long denominator = b * d;

        long gcd = gcd(numerator, denominator);

        System.out.println((numerator / gcd) + " "  + (denominator / gcd));

    }


    static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
