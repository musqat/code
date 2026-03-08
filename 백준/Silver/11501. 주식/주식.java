import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] days = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                days[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(cal(days));
        }
    }

    private static long cal(int[] days) {
        int len = days.length;
        int top = days[len - 1];
        long result = 0;
        for (int i = len - 2; i >= 0 ; i--) {
            if (days[i] < top) {
                result += top - days[i];
            }else {
                top = days[i];
            }

        }

        return result;
    }
}
