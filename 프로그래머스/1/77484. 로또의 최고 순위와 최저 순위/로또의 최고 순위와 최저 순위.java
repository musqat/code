class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int count = 0;
        int zeroCount = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0){
                zeroCount++;
            }

            for (int j = 0; j < win_nums.length; j++) {
                if (win_nums[j] == lottos[i]){
                       count++;
                }
            }
        }

        answer[0] = rank[zeroCount + count];
        answer[1] = rank[count];




        return answer;
    }
}