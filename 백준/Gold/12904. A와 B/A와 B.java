import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        while (B.length() > A.length()) {
            if (B.charAt(B.length() - 1) == 'A' ){
                B = B.substring(0, B.length() - 1);
            }else {
                B = new StringBuilder(B.substring(0, B.length() -1)).reverse().toString();
            }
        }


        System.out.println(B.equals(A) ? 1 : 0);

    }
}
