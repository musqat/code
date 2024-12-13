import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        int decimal = 0;
        for (int i = 0; i < m; i++) {
            decimal += arr[i] * Math.pow(A, m - 1- i );
        }

        List<Integer> result = new ArrayList<>();
        while (decimal > 0){
            result.add(decimal % B);
            decimal /= B;
        }

        Collections.reverse(result);
        for (int num : result){
            System.out.print(num +  " ");
        }


    }
}
