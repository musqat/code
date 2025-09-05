import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1 || N == 3) {
            System.out.println(-1);
            return;
        }

        int five = N / 5;
        int r = N % 5;

        int ans = 0;

        if (r % 2 == 0) {
            ans = five + r / 2;
        } else {
            ans = (five - 1) + (r + 5) / 2;
        }
        System.out.println(ans);
    }
}