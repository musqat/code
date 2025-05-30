import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());
            cal(C);
        }


    }

    public static void cal(int C){
        int[] coins = {25, 10, 5, 1};
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < coins.length; i++) {
            int cnt = C / coins[i];
            sb.append(cnt).append(" ");
            C %= coins[i];

        }
        System.out.println(sb.toString().trim());

    }
}
