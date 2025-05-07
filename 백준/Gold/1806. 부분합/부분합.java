import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int minLen = Integer.MAX_VALUE;

        int sum = 0, start = 0, end = 0;

        while (end <= N) {
            if (sum < S) {
                if (end == N) break;
                sum += arr[end++]; // 오른쪽으로 확장
            } else {
                minLen = Math.min(minLen, end - start);
                sum -= arr[start++]; // 왼쪽 축소
            }
        }

        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
