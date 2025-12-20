class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] count = new int[201];

        for (int[] line : lines){
            int start = line[0] + 100;
            int end = line[1] + 100;

            for (int i = start; i < end; i++) {
                count[i]++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2){
                answer++;
            }

        }

        return answer;
    }
}