import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(factorial(n));
        
    }
    private static BigInteger factorial(int n) {
        if (n == 0 || n == 1) return BigInteger.ONE;
        return factorialDivideAndConquer(1, n);
    }
    private static BigInteger factorialDivideAndConquer(int start, int end) {
        if (start == end) return BigInteger.valueOf(start);
        if (start + 1 == end) return BigInteger.valueOf(start).multiply(BigInteger.valueOf(end));

        int mid = (start + end) / 2;
        return factorialDivideAndConquer(start, mid).multiply(factorialDivideAndConquer(mid + 1, end));
    }

}
