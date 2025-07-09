import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int left = 1;
        int right = houses[N-1] - houses[0];
        int answer = 0;

        while (left <= right){
            int mid = (left + right) / 2;
            int install = countWifi(houses, mid);

            if (install >= T){
                answer = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static int countWifi(int[] arr, int dist){
        int count = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dist){
                count++;
                last = arr[i];
            }
        }
        return count;
    }
}
