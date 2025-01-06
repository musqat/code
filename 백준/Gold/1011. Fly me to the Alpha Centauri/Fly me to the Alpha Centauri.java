import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(minStep(A,B));
        }

    }

    private static int minStep(int A,int B){
        long dist = B - A;
        long k = 1;

        while (k * k <= dist){
            k++;
        }
        k--;

        if (dist == k * k){
            return (int) (2*k - 1);
        }else if (dist <= k * k + k){
            return (int) (2 * k);
        }else {
            return (int) (2 * k + 1);
        }

    }
}
