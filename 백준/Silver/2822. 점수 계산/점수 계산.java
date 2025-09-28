import java.io.*;
import java.util.Arrays;

public class Main {

    static class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Pair[] pairs = new Pair[8];

        for (int i = 0; i < 8; i++) {
            int score = Integer.parseInt(br.readLine());
            pairs[i] = new Pair(score, i + 1);
        }

        Arrays.sort(pairs, (a,b) -> a.val - b.val);

        int sum = 0;
        int[] idxs = new int[5];

        for (int i = 3; i < 8; i++) {
            sum += pairs[i].val;
            idxs[i-3] = pairs[i].idx;
        }

        System.out.println(sum);

        Arrays.sort(idxs);

        for (int idx : idxs){
            System.out.print(idx + " ");
        }

    }
}