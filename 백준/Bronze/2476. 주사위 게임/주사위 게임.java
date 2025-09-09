import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            max = Math.max(max, calculate(a,b,c));
        }
        System.out.println(max);

    }

    static int calculate(int a, int b, int c) {
        if (a == b && b == c) {
            return 10000 + a * 1000;
        } else if (a == b || b == c || a == c) {
            if (a == b) {
                return 1000 + a * 100;
            } else if (b == c) {
                return 1000 + b * 100;
            } else {
                return 1000 + c * 100;
            }

        } else {

            int tmp = 0;
            if (a > b) {
                tmp = a;
            } else if (b > c) {
                tmp = b;
            } else {
                tmp = c;
            }

            return tmp * 100;
        }

    }

}
