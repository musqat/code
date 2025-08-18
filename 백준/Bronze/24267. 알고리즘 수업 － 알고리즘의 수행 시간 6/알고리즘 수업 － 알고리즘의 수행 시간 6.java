import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long count = N * (N - 1) * (N - 2) / 6;  // C(N, 3)

        System.out.println(count);
        System.out.println(3);


    }
}
