class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] countX = new int[10];
        int[] countY = new int[10];
        int[] mix = new int[10];

        for (int i = 0; i < X.length(); i++) {
            int num = X.charAt(i) - '0';
            countX[num]++;
        }

        for (int i = 0; i < Y.length(); i++) {
            int num = Y.charAt(i) - '0';
            countY[num]++;
        }

        for (int i = 0; i < 10; i++) {
            if (countX[i] >= 1 && countY[i] >= 1) {
                mix[i] = Math.min(countX[i], countY[i]);
            }
        }

        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < mix[i]; j++) {
                sb.append(i);
            }
        }
        if (sb.length() == 0) return "-1";

        if (sb.charAt(0) == '0') return "0";

        return sb.toString();


    }
}