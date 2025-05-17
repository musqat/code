import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = N-1; i >= 0; i--) {
            for (int j = 1; j < N - i; j++) {
                System.out.print(" ");
            }
            for (int j = N; j >= N - i; j--) {
                System.out.print("*");
            }
            System.out.println();

        }

    }
}
