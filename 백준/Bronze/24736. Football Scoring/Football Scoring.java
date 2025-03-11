import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int T,F,S,P,TP = 0;

        for (int i = 0; i < 2; i++) {
            T = sc.nextInt();
            F = sc.nextInt();
            S = sc.nextInt();
            P = sc.nextInt();
            TP = sc.nextInt();

            System.out.print(football(T, F, S, P, TP) + " ");
        }

    }

    private static int football(int T, int F, int S, int P, int TP) {
        return (T * 6) + (F * 3) + (S * 2) + P + (TP * 2);

        
    }
}
