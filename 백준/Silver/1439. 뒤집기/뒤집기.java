import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int zero = 0;
        int one = 0;
        char prev = line.charAt(0);

        if (prev == '0') zero++;
        else one++;


        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) != prev) {
                if (line.charAt(i) == '0') zero++;
                else one++;
                prev = line.charAt(i);
            }
        }

        System.out.println(Math.min(zero,one));

    }
}
