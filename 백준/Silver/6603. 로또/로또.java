import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            if (K == 0) break;
            S = new int[K];
            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, new ArrayList<Integer>());
            System.out.println();

        }
    }

    static void dfs(int idx, List<Integer> selected){
        if (selected.size() == 6){
            System.out.println(selected.toString().replaceAll("[^0-9 ]", ""));
            return;
        }
        if (selected.size() + S.length - idx < 6) return;
        selected.add(S[idx]);
        dfs(idx + 1, selected);
        selected.remove(selected.size() - 1);
        dfs(idx + 1, selected);
    }
}
