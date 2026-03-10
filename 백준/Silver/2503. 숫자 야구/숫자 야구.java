import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] arr = new String[504];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] queries = new String[N];
        int[] strikes = new int[N];
        int[] balls = new int[N];

        make();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            queries[i] = st.nextToken();
            strikes[i] = Integer.parseInt(st.nextToken());
            balls[i] = Integer.parseInt(st.nextToken());
        }

        for (String candidate : arr) {
            boolean valid = true;
            for (int i = 0; i < N; i++) {
                if (!checkS(candidate, queries[i], strikes[i], balls[i])) {
                    valid = false;
                    break;
                }

            }
            if (valid) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean checkS(String candidate, String query, int strike, int ball) {
        int strikeTmp = 0;
        int ballTmp = 0;

        for (int i = 0; i < 3; i++) {
            if (candidate.charAt(i) == query.charAt(i)) {
                strikeTmp++;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (candidate.charAt(i) == query.charAt(j) && i != j) {
                    ballTmp++;
                }

            }
        }

        if (strike == strikeTmp && ball == ballTmp) {
            return true;
        }

        return false;
    }

    private static void make() {
        int tmp = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i != j && j != k && k != i) {
                        arr[tmp] = i + "" + j + "" + k;
                        tmp++;
                    }
                }

            }

        }
    }
}
