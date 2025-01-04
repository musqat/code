import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = new int[N];
        Arrays.fill(result, 0);

        for (int i = 0; i < N; i++) {
            int count = arr[i];
            int position = 0;

            for (int j = 0; j < N; j++) {
                if (result[j] == 0){
                    if (count == 0){
                        position = j;
                        break;
                    }
                    count--;
                }

            }
            result[position] = i + 1;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");

        }

    }
}
