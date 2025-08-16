import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int winner = 0;
        int winnerSum = 0;

        for (int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmp = 0;
            for (int j = 0; j < 4; j++) {
                tmp += Integer.parseInt(st.nextToken());
            }

            if (tmp > winnerSum) {
                winner = i;
                winnerSum = tmp;
            }

        }


        System.out.println(winner + " " + winnerSum);
    }

}
