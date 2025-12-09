class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left +1)];


        for (long i = left; i <= right; i++) {
            int row = (int) (i / n);
            int col = (int) (i % n);

            int val = Math.max(row, col) + 1;

            answer[(int) (i -left)] = val;
        }

        return answer;
    }
}