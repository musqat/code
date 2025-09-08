import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    static char[] ops;
    static boolean[] used = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        ops = new char[K];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            ops[i] = st.nextToken().charAt(0);

        }

        String maxVal = find(true);
        Arrays.fill(used, false);
        String minVal = find(false);

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    static String find(boolean getMax) {
        StringBuilder path = new StringBuilder();
        if (dfs(0, path, getMax)) return path.toString();

        return "";
    }


    static boolean dfs(int idx, StringBuilder path, boolean getMax) {
        if (idx == K + 1) return true;

        if (getMax) {
            for (int d = 9; d >= 0; d--) {
                if (used[d]) continue;
                if (idx > 0) {
                    int prev = path.charAt(idx - 1) - '0';
                    if (!ok(prev, d, ops[idx - 1])) continue;
                }

                used[d] = true;
                path.append(d);
                if (dfs(idx + 1, path, getMax)) return true;
                path.deleteCharAt(path.length() - 1);
                used[d] = false;
            }
        } else {
            for (int d = 0; d <= 9; d++) {
                if (used[d]) continue;
                if (idx > 0) {
                    int prev = path.charAt(idx - 1) - '0';
                    if (!ok(prev, d, ops[idx - 1])) continue;
                }
                used[d] = true;
                path.append(d);
                if (dfs(idx + 1, path, getMax)) return true;
                path.deleteCharAt(path.length() - 1);
                used[d] = false;

            }
        }
        return false;
    }

    static boolean ok(int a, int b, char op) {
        return op == '<' ? a < b : a > b;
    }
}
