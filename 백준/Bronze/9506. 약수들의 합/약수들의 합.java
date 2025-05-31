import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == -1) {
                break;
            }

            int tmp = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(N).append(" = ");

            for (int i = 1; i < N; i++) {
                if (N % i == 0) {
                    tmp += i;
                    sb.append(i).append(" + ");

                }
            }

            if (tmp == N){
                sb.setLength(sb.length() - 3);
                System.out.println(sb);
            }else {
                System.out.println(N + " is NOT perfect.");
            }
        }

    }

}
