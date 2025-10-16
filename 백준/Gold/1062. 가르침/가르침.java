import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static final String prefix = "antic";
    static boolean[] learned = new boolean[26];
    static List<int[]> words = new ArrayList<>();
    static List<Integer> candidates = new ArrayList<>();
    static int need;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            for (int i = 0; i < N; i++) {
                br.readLine();
            }
            System.out.println(0);
            return;
        }

        if (K == 26) {
            System.out.println(N);
            return;
        }

        for (char c : prefix.toCharArray()) {
            learned[c - 'a'] = true;
        }

        boolean[] union = new boolean[26];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String mid = s.substring(4, s.length() - 4);

            boolean[] seen = new boolean[26];
            for (int j = 0; j < mid.length(); j++) {
                char c = mid.charAt(j);
                int idx = c - 'a';
                if (idx < 0 || idx >= 26) continue;
                if (learned[idx]) continue;
                seen[idx] = true;
            }

            List<Integer> list = new ArrayList<>();

            for (int ch = 0; ch < 26; ch++) {
                if (seen[ch]) {
                    list.add(ch);
                    union[ch] = true;
                }
            }

            int[] arr = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                arr[j] = list.get(j);
            }
            words.add(arr);

        }

        for (int ch = 0; ch < 26; ch++) {
            if (!learned[ch] && union[ch]) candidates.add(ch);
        }

        need = K - 5;

        if (need >= candidates.size()) {
            System.out.println(N);
            return;
        }

        dfs(0, 0);
        System.out.println(answer);
    }


    static void dfs(int idx, int picked) {
        if (picked + (candidates.size() - idx) < need) return;

        if (picked == need) {
            int count = 0;
            outer:
            for (int[] arr : words) {
                for (int ch : arr) {
                    if (!learned[ch]) {
                        continue outer;
                    }
                }
                count++;
            }
            answer = Math.max(answer, count);
            return;
        }

        if (idx == candidates.size()) return;

        int pick = candidates.get(idx);
        learned[pick] = true;
        dfs(idx + 1, picked + 1);
        learned[pick] = false;

        dfs(idx + 1, picked);
    }
}