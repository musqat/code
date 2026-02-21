import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringBuilder sb = new StringBuilder();
            String v = Integer.toBinaryString(Integer.parseInt(br.readLine()));

            for (int i = v.length() - 1; i >= 0; i--) {
                if (v.charAt(i) == '1') {
                    sb.append(v.length() - 1 - i).append(' ');
                }
            }
            System.out.println(sb.toString());
        }

    }
}