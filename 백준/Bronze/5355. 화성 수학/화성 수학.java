import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            double a = Double.parseDouble(s[0]);

            for (int j = 1; j < s.length; j++) {
                if (s[j].equals("@")){
                    a = a * 3;
                }else if (s[j].equals("#")){
                    a -= 7;
                } else if (s[j].equals("%")) {
                    a += 5;
                }
            }

            System.out.printf("%.2f %n" ,a);
        }

    }
}