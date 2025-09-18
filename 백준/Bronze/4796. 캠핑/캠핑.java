
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == P && P == V && L == 0) {
                break;
            }

            int result = 0;

            int VP = V / P;
            result += VP * L;

            int restVP = V % P;

            if (restVP > L) {
                result += L;
            } else {
                result += restVP;
            }


            System.out.println("Case " + count + ": " + result);


            count++;
        }


    }
}