import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());

            a = a.mod(BigInteger.TEN);
            BigInteger result = a.modPow(b, BigInteger.TEN);

            if (result.equals(BigInteger.ZERO)) {
                System.out.println(10);
            } else {
                System.out.println(result);
            }



        }


    }


}