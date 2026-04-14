class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder full = new StringBuilder();

        for (int i = 0; i < t * m; i++) {
            full.append(Integer.toString(i, n).toUpperCase());
        }

        int idx = 0;
        while (answer.length() < t) {
            answer.append(full.charAt(p - 1 + (m * idx)));
            idx++;
        }

        return answer.toString();
    }
}