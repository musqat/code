import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[] failRatio = new double[N + 1];

        for (int i = 1; i <= N; i++) {
            int reached = 0;
            int failed = 0;

            for (int stage : stages){
                if (stage >= i) reached++;
                if (stage == i) failed++;
            }

            failRatio[i] = (reached == 0) ? 0 : (double) failed / reached;
        }

        Integer[] stageNumbers = new Integer[N];
        for (int i = 0; i < N; i++) {
            stageNumbers[i] = i + 1;
        }

        Arrays.sort(stageNumbers, (a,b) -> {
            if (failRatio[b] != failRatio[a]){
                return Double.compare(failRatio[b],failRatio[a]);
            }
            return a-b;
        });

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = stageNumbers[i];

        }


        return result;
    }
}