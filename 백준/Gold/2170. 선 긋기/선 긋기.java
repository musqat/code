import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int result = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int start = arr[0][0];
        int end = arr[0][1];
        for (int i = 1; i < N; i++) {
            if (end >= arr[i][0]){
                end = Math.max(end, arr[i][1]);
            }else {
                result +=  end - start;
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        result += end - start;
        System.out.println(result);
    }
}
