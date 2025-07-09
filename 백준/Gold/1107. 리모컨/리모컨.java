import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cur = 100;
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        boolean[] broke = new boolean[10];

        if (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < T; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                broke[tmp] = true;
            }
        }

        int minPress = Math.abs(N - cur);
        for (int i = 0; i <= 1000000 ; i++) {
            if (isValid(i, broke)) {
                int press = String.valueOf(i).length() + Math.abs(i - N);
                minPress = Math.min(minPress, press);
            }
        }
        System.out.println(minPress);
    }

    static boolean isValid(int num, boolean[] broke){
        if (num == 0) return !broke[0];
        while (num > 0){
            if (broke[num % 10]) return false;
            num/= 10;
        }
        return true;
    }
}
