import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        if (isSquare(T)) {
            System.out.println(1);
            return;
        }

        boolean twoSquares = false;
        for (int a = 0; a * a <= T; a++) {
            int bSquared = T - a * a;
            if (isSquare(bSquared)) {
                twoSquares = true;
                break;
            }
        }
        if (twoSquares) {
            System.out.println(2);
            return;
        }

        int temp = T;

        while (temp % 4 == 0) {
            temp /= 4;
        }

        if (temp % 8 != 7) {
            System.out.println(3);
            return;
        }

        System.out.println(4);


    }

    private static boolean isSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return sqrt * sqrt == n;
    }

}
