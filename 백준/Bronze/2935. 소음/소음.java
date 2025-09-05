import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger A = new BigInteger(br.readLine());
        String operator = br.readLine();
        BigInteger  B = new BigInteger(br.readLine());


        if (operator.equals("+")) {
            System.out.println(A.add(B));
        } else {
            System.out.println(A.multiply(B));
        }
    }
}