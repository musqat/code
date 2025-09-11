import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int lower = 0, upper = 0, digit = 0, space = 0;

            for (char c : line.toCharArray()) {
                if (c >= 'a' && c <= 'z') lower++;
                else if (c >= 'A' && c <= 'Z') upper++;
                else if (c >= '0' && c <= '9') digit++;
                else if (c == ' ') space++;
            }

            System.out.printf("%d %d %d %d%n", lower, upper, digit, space);
        }
    }
}
