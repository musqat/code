import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        StringTokenizer st =new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if ((arr[0] + arr[1]) <= arr[2]){
            arr[2] = arr[0] + arr[1] - 1;
        }

        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += arr[i];
        }

        System.out.println(result);

    }
}
