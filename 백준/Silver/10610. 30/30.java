import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] digits = br.readLine().toCharArray();

        boolean hasZero = false;
        int sum = 0;
        for (char c : digits){
            int num = c - '0';
            if (num == 0) hasZero = true;
            sum += num;
        }

        if (hasZero && sum % 3 == 0){
            Arrays.sort(digits);
            StringBuilder sb = new StringBuilder(new String(digits));
            System.out.println(sb.reverse());
        }else {
            System.out.println(-1);
        }
    }
}

