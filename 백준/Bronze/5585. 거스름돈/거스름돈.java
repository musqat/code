import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] coins = {500,100,50,10,5,1};
        int N = Integer.parseInt(br.readLine());
        int buck = 1000 - N;
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            count += buck / coins[i];
            buck = buck % coins[i];

        }

        System.out.println(count);

    }
}
