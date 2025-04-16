import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (i < 100) {
                count++;
            } else {
                int a = i / 100;
                int b = (i / 10) % 10;
                int c = i % 10;
                if ((a - b) == (b - c)) {
                    count++;
                }
            }

        }
        System.out.println(count);
    }
}
