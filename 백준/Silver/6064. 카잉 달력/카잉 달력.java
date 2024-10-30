import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(calender(M, N, x, y));
        }

    }

    public static int calender(int M, int N, int x, int y) {
        int maxYear = lcm(M, N);
        while (x <= maxYear) {
            if ((x - 1) % N == (y - 1)) {
                return x;
            } else {
                x += M;
            }
        }
        return -1;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

}