
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());


        System.out.println(combination(A, B));
    }

    static BigInteger combination(int n, int r){
        if (r > n - r) r = n - r;
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < r; i++) {
            result = result.multiply(BigInteger.valueOf(n - i));
            result = result.divide(BigInteger.valueOf(i + 1));
        }

        return result;

    }
}