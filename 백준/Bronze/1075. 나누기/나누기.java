import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        int prefix = (N / 100) * 100;

        for (int i = 0; i < 100 ; i++) {
            int newNumber = prefix + i;
            if (newNumber % F == 0) {
                System.out.printf("%02d\n", i);
                break;
            }
        }
    }
}