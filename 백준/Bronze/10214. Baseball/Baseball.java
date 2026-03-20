import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int Yonsei = 0, Korea = 0;

            for (int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Yonsei += Integer.parseInt(st.nextToken());
                Korea += Integer.parseInt(st.nextToken());

            }
            if (Yonsei == Korea) System.out.println("Draw");
            else System.out.println(Yonsei > Korea ? "Yonsei" : "Korea");


        }

    }
}
