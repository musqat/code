import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a,b) -> {
            if (a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int count = 0;
        int endTime = 0;

        for (int[] arrs: arr){
            if (arrs[0] >= endTime){
                endTime = arrs[1];
                count++;
            }
        }
        System.out.println(count);

    }

}
