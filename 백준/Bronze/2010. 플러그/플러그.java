import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(br.readLine());

        }

        System.out.println(sum - (N - 1));
    }
}