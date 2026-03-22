import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine().trim();
        long MOD = 20000303;
        long result = 0;

        for (char c : N.toCharArray()) {
            result = (result * 10 + (c - '0')) % MOD;
        }

        System.out.println(result);
    }

}
