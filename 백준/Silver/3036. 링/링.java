import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int A = arr[0];
        int B = 0;
        for (int i = 1; i < T; i++) {
            B = arr[i];
            System.out.println(A / GCD(A, B) + "/" + B / GCD(A, B));
        }
    }

    static int GCD(int a, int b){
        if (b == 0){
            return a;
        }
        return GCD(b, a % b);
    }
}