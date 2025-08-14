import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int no = 0;
        int yes = 0;
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(br.readLine());
            if(c == 0) no++;
            else yes++;
        }

        System.out.println(yes > no ? "Junhee is cute!": "Junhee is not cute!");


    }
}
