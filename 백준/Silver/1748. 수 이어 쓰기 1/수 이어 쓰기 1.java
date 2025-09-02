import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int len = String.valueOf(N).length();
        int result = 0;

        for (int i = 1; i < len; i++) {
            result += 9 * Math.pow(10, i - 1) * i;
        }

        int start = (int) Math.pow(10, len - 1);
        result += (N - start + 1) * len;

        System.out.println(result);

    }
}