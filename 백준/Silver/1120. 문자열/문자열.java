
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int alen = a.length();
        int blen = b.length();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= blen - alen; i++) {
            int count = 0;

            for (int j = 0; j < alen; j++) {
                if (a.charAt(j) != b.charAt(j + i)){
                    count++;
                }
            }
            answer = Math.min(answer, count);

        }

        System.out.println(answer);
    }
}