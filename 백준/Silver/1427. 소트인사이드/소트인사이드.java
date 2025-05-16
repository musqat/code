import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] N = br.readLine().toCharArray();
        Arrays.sort(N);

        for (int i = N.length- 1; i >= 0 ; i--) {
            System.out.print(N[i]);
        }
    }
}
