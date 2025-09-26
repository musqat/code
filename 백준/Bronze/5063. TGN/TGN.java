import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int profit = e - c;

            if (r <profit) {
                System.out.println("advertise");
            } else if (r == profit) {
                System.out.println("does not matter");
            }else {
                System.out.println("do not advertise");
            }

        }


    }
}