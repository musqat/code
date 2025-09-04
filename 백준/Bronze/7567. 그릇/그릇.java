import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int sum = 0;

        for (int i = 0; i < line.length(); i++) {
            if (i < line.length() - 1 && line.charAt(i) == line.charAt(i+1)) {
                sum += 5;

            }else {
                sum += 10;
            }

        }


        System.out.println(sum);
    }
}